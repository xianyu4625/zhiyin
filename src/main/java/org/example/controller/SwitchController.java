package org.example.controller;

import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.pojo.Switch;
import org.example.pojo.SwitchView;
import org.example.service.SwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/switch")
public class SwitchController {
    @Autowired
    private SwitchService switchService;
//系统自动添加
    @PostMapping("/addlog")
    public Result add(@RequestBody @Validated Switch switchs){
        switchService.add(switchs);
        return Result.success();
    }
//    删除
    @PostMapping("/deletelog")
    public Result deletelog(@RequestBody Switch switchs){
        switchService.delete(switchs);
        return Result.success();
    }
//    用户查看个人的兑换记录
    @GetMapping("/loglist")
    public Result<PageBean<SwitchView>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String goodname
    ){
        PageBean<SwitchView> pageBean=switchService.list(pageNum,pageSize,username,goodname);
        return Result.success(pageBean);
    }
//    查看所有的兑换记录
    @GetMapping("/alllist")
    public Result<PageBean<SwitchView>> alllist(
        Integer pageNum,
        Integer pageSize,
        @RequestParam(required = false) String username,
        @RequestParam(required = false) String goodname
    ){
    PageBean<SwitchView> pageBean=switchService.alllist(pageNum,pageSize,username,goodname);
    return Result.success(pageBean);
    }
}
