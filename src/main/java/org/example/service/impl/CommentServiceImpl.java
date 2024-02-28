package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.CommentMapper;
import org.example.pojo.Comment;
import org.example.pojo.PageBean;
import org.example.service.CommentService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public void addcomment(Integer suggestionid, String content) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userid=(Integer)map.get("id");
        commentMapper.addcomment(suggestionid,content,userid);
    }

    @Override
    public PageBean<Comment> selectcomment(Integer pageNum, Integer pageSize, Integer suggestionid) {
        PageBean<Comment> pb=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> comments= commentMapper.selectcomment(suggestionid);
        PageInfo<Comment> pageInfo=new PageInfo<>(comments);
        pb.setTotal(pageInfo.getTotal());
        pb.setItems(comments);
        return pb;
    }

    @Override
    public void deletecomment(Comment comment) {
        commentMapper.deletecomment(comment);
    }


}
