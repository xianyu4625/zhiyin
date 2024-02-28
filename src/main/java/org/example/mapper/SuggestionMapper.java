package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.Suggestion;
import org.example.pojo.SuggestionView;

import java.util.List;

@Mapper
public interface SuggestionMapper {


    List<SuggestionView> selected(String username, String content,Integer pageNum, Integer pageSize);


    @Insert("insert into suggestion(userid,question,suggestion,timestamp) values (#{userid},#{question},#{suggestion},now())")
    void addsuggestion(Suggestion suggestion);
    @Update("update suggestion set `show`=#{show} where suggestionid=#{suggestionid}")
    void updateshow(Suggestion suggestion);
    @Update("update suggestion set deleted=1 where suggestionid=#{suggestionid}")
    void deletesuggestion(Suggestion suggestion);

    List<SuggestionView> selectself(Integer userid, String username, String content);
    @Select("SELECT COUNT(*) FROM suggestion")
    Integer mount();
}
