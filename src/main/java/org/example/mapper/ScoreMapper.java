package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ScoreMapper {
    @Insert("insert into scorerecord (userid,score) values (#{id},#{score})")
    void add(Integer id, Integer score);
    @Update("update scorerecord set score=score+#{score} where userid=#{id}")
    void update(Integer id, Integer score);
}
