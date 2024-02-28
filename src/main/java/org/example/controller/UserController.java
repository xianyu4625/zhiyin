package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.ScoreService;
import org.example.service.Userservice;
import org.example.utils.JwtUtil;
import org.example.utils.Md5Util;
import org.example.utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.MultiDocPrintService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private Userservice userservice;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$")  String password){
        User registeruser=userservice.findByUserName(username);
        if (registeruser==null){
            userservice.register(username,password);
//注册之后新增积分表中的信息
            User user=userservice.findByUserName(username);
            Integer id=user.getId();
//            积分初始给10分
            scoreService.add(id,10);
            return Result.success();
        }else{
            return Result.error("该用户名已存在");
        }
    }
    @PostMapping("/login")
    public Result<String> login(String username,String password){
        User loginuser=userservice.findByUserName(username);
        if (loginuser==null){
            return Result.error("未查找该用户");
        }
        else{
            if (Md5Util.getMD5String(password).equals(loginuser.getPassword())){
                Map<String,Object> claims=new HashMap<>();
                claims.put("id",loginuser.getId());
                claims.put("username",loginuser.getUsername());
                String token= JwtUtil.genToken(claims);
//                将token存储到redis中\
                ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
                operations.set(token,token,12, TimeUnit.HOURS);
                return Result.success(token);
            }
            return Result.error("密码错误");
        }
    }
    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username=(String) map.get("username");
        User user= userservice.findByUserName(username);
        return Result.success(user);
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        userservice.update(user);
        return Result.success();
    }
    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params,@RequestHeader("Authorization") String token){
        String old_pwd=params.get("old_pwd");
        String new_pwd=params.get("new_pwd");
        String re_pwd=params.get("re_pwd");
//        System.out.println(old_pwd+new_pwd+re_pwd);
//        判断是否为空
        if (!StringUtils.hasLength(old_pwd)||!StringUtils.hasLength(new_pwd)||!StringUtils.hasLength(re_pwd)){
            return Result.error("缺少必要参数");
        }
//        验证旧密码正确性
        Map<String,Object> map= ThreadLocalUtil.get();
        String username=(String)map.get("username");
        User user=userservice.findByUserName(username);
        if (!Md5Util.getMD5String(old_pwd).equals(user.getPassword())){
         return Result.error("旧密码错误");
        }
//        判断两次输入密码是否一致
        if (!new_pwd.equals(re_pwd)){
            return Result.error("两次输入密码不同");
        }
        userservice.updatepwd(new_pwd);
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return Result.success();
    }
    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarurl){
        userservice.updateAvatar(avatarurl);
        return Result.success();
    }
    @PatchMapping("/updatescore")
    public Result updatescore(Integer score){
        Map<String,Object> user = ThreadLocalUtil.get();
        Integer id=(Integer) user.get("id");
        userservice.updatescore(id,score);
        return Result.success();
    }
}
