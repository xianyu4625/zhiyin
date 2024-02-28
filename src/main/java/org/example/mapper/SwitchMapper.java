package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Switch;
import org.example.pojo.SwitchView;

import java.util.List;

@Mapper
public interface SwitchMapper {
    List<SwitchView> list(String username, String goodname, Integer userid);

    @Insert("insert into switch (userid,goodid,`change`,timestamp) values (#{userid},#{goodid},#{change},now())")
    void add(Switch switchs);
    @Delete("update switch set deleted=1 where switchid=#{switchid}")
    void delete(Switch switchs);


    List<SwitchView> alllist(String username, String goodname);
}
