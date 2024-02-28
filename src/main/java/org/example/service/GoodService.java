package org.example.service;

import org.example.pojo.Goods;
import org.example.pojo.PageBean;
import org.example.pojo.User;

import java.util.List;

public interface GoodService {

    void add(Goods goods);

    void updategoods(Goods goods);

    void deletegoods(Goods goods);

    List<Goods> select( String goodname, Integer score);
}
