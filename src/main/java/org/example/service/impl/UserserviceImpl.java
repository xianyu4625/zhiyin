package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.Userservice;
import org.example.utils.Md5Util;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserserviceImpl implements Userservice {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String username) {
        User u=userMapper.findByUsername(username);
        return u;
    }

    @Override
    public void register(String username, String passwords) {
        String password= Md5Util.getMD5String(passwords);
        userMapper.add(username,password);
    }

    @Override
    public void update(User user) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        user.setId(id);
        userMapper.update(user);
    }

    @Override
    public void updatepwd(String newPwd) {
        String password=Md5Util.getMD5String(newPwd);
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        userMapper.updatepwd(password,id);
    }

    @Override
    public void updateAvatar(String avatarurl) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        userMapper.updateAvatar(avatarurl,id);
    }

    @Override
    public void updatescore(Integer id, Integer score) {
        userMapper.updatescore(id,score);
    }

}
