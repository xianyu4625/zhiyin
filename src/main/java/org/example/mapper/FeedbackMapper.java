package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    @Insert("insert into feedback (userid,`content`,timetemp,suggestionid) values (#{userid},#{content},now(),#{suggestionid})")
    void addfeedback(Feedback feedback);
    @Select("select * from feedback where suggestionid=#{suggestionid} and deleted=0")
    List<Feedback> selectfeedback(Integer suggestionid);
    @Update("update feedback set content=#{content},timetemp=now() where suggestionid=#{suggestionid}")
    void updatefeedback(Feedback feedback);
    @Update("update feedback set deleted=1 where feedbackid=#{feedbackid}")
    void deletefeedback(Feedback feedback);
}
