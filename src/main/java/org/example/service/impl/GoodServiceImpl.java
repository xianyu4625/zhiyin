package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.GoodsMapper;
import org.example.pojo.Goods;
import org.example.pojo.PageBean;
import org.example.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void add(Goods goods) {
        goodsMapper.add(goods);
    }

    @Override
    public void updategoods(Goods goods) {
        goodsMapper.updategoods(goods);
    }

    @Override
    public void deletegoods(Goods goods) {
        goodsMapper.deletegoods(goods);
    }

    @Override
    public List<Goods> select( String goodname, Integer score) {
//        声明pagebean对象
//        PageBean<Goods> pb=new PageBean<>();
//        使用pagehelper开启分页模糊查询
//        PageHelper.startPage(pageNum,pageSize);
//        查找商品数据
        List<Goods> goods=goodsMapper.select(goodname,score);
//        获取总的记录数
//        PageInfo<Goods> pageInfo=new PageInfo<>(goods);
//        pb.setTotal(pageInfo.getTotal());
//        pb.setItems(goods);
        return goods;
    }
}
