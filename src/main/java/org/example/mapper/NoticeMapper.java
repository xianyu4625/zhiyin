package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Notice;

import java.util.List;

@Mapper
public interface NoticeMapper {
    @Insert("insert into `notice` (userid,content,timestamp) values (#{userid},#{content},now())")
    void addnotice(Integer userid,String content);
    @Update("update `notice` set `show`=#{show} where noticeid=#{noticeid}")
    void updateshow(Notice notice);
    @Update("update `notice` set content=#{content} where noticeid=#{noticeid}")
    void updatenotice(Notice notice);

    List<Notice> selectnotice(String content);
}
