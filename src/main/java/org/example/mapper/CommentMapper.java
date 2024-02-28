package org.example.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment(userid,content,timestamp,suggestionid) values (#{userid},#{content},now(),#{suggestionid})")
    void addcomment(Integer suggestionid, String content,Integer userid);
    @Select("select * from comment where suggestionid=#{suggestionid} and deleted=0")
    List<Comment> selectcomment(Integer suggestionid);
    @Delete("UPDATE comment set deleted=1 where commentid=#{commentid}")
    void deletecomment(Comment comment);
}
