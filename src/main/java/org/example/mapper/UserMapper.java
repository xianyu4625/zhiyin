package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findByUsername(String username);
    @Insert("insert into user (username,password,createtime,updatetime,score,roleid) " +
            "values (#{username},#{password},now(),now(),10,2)")
    void add(String username, String password);
    @Update("update user set nickname=#{nickname},email=#{email},updatetime=now() where id=#{id}")
    void update(User user);
    @Update("update user set password=#{password},updatetime=now() where id=#{id}")
    void updatepwd(String password,Integer id);
    @Update("update user set userpic=#{avatarurl},updatetime=now() where id=#{id}")
    void updateAvatar(String avatarurl, Integer id);
    @Update("update user set score=score+#{score} where id=#{id}")
    void updatescore(Integer id, Integer score);
}
