package org.example.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.SwitchMapper;
import org.example.pojo.PageBean;
import org.example.pojo.Switch;
import org.example.pojo.SwitchView;
import org.example.service.ScoreService;
import org.example.service.SwitchService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SwitchServiceImpl implements SwitchService {
    @Autowired
    private SwitchMapper switchMapper;
    @Override
    public void add(Switch switchs) {
        switchMapper.add(switchs);
    }

    @Override
    public void delete(Switch switchs) {
        switchMapper.delete(switchs);
    }

    @Override
    public PageBean<SwitchView> list(Integer pageNum, Integer pageSize, String username, String goodname) {
        // 创建 pagebean 对象
        PageBean<SwitchView> pageBean=new PageBean<>();
        // 开启分页模糊查询
        PageHelper.startPage(pageNum,pageSize);
        // 调用 mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        List<SwitchView> sv=switchMapper.list(username,goodname,userid);
        // 获取 PageInfo 对象，从中获取总记录条数
        PageInfo<SwitchView> pageInfo = new PageInfo<>(sv);
        // 数据填充到 pagebean 对象
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setItems(sv);
        return pageBean;
    }

    @Override
    public PageBean<SwitchView> alllist(Integer pageNum, Integer pageSize, String username, String goodname) {
        // 创建 pagebean 对象
        PageBean<SwitchView> pageBean=new PageBean<>();
        // 开启分页模糊查询
        PageHelper.startPage(pageNum,pageSize);

        List<SwitchView> sv=switchMapper.alllist(username,goodname);
        // 获取 PageInfo 对象，从中获取总记录条数
        PageInfo<SwitchView> pageInfo = new PageInfo<>(sv);
        // 数据填充到 pagebean 对象
        pageBean.setTotal(pageInfo.getTotal());
        pageBean.setItems(sv);
        return pageBean;
    }

}
