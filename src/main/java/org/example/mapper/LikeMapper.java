package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Like;

import java.util.List;

@Mapper
public interface LikeMapper {
    @Insert("insert into `like`(userid,timestamp,suggestionid) values (#{userid},now(),#{suggestionid})")
    void addlike(Like like);
    @Select("select * from `like` where suggestionid=#{suggestionid} and deleted=0")
    List<Like> showlike(Integer suggestionid);
    @Delete("update `like` set deleted=1 where suggestionid=#{suggestionid} and userid=#{userid}")
    void deletelike(Like like);
}
