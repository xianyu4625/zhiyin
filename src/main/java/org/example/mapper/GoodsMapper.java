package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Goods;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Insert("INSERT INTO goods set goodname=#{goodname},scription=#{scription},score=#{score},goodimg=#{goodimg}")
    void add(Goods goods);
    @Update("update goods set goodname=#{goodname},scription=#{scription},goodimg=#{goodimg},score=#{score} where goodid=#{goodid}")
    void updategoods(Goods goods);
    @Delete("update goods set deleted=1 where goodid=#{goodid}")
    void deletegoods(Goods goods);

    List<Goods> select(String goodname, Integer score);
}
