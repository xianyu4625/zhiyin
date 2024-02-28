package org.example.service;

import org.example.pojo.User;

public interface Userservice {
    User findByUserName(String username);

    void register(String username, String password);

    void update(User user);

    void updatepwd(String newPwd);

    void updateAvatar(String avatarurl);

    void updatescore(Integer id, Integer score);
}
