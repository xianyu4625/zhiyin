package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.example.mapper.LikeMapper;
import org.example.pojo.Like;
import org.example.pojo.PageBean;
import org.example.service.LikeService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeMapper likeMapper;

    @Override
    public void addlike(Like like) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        like.setUserid(userid);
        likeMapper.addlike(like);
    }

    @Override
    public PageBean<Like> showlike(Integer pageNum, Integer pageSize,Integer suggestionid) {
        PageBean<Like> pb=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Like> like= likeMapper.showlike(suggestionid);
        PageInfo<Like> pageInfo=new PageInfo<>(like);
        pb.setTotal(pageInfo.getTotal());
        pb.setItems(like);
        return pb;
    }

    @Override
    public void deletelike(Like like) {
        Map<String,Object> map=ThreadLocalUtil.get();
        Integer userid = (Integer) map.get("id");
        like.setUserid(userid);
        likeMapper.deletelike(like);
    }
}
