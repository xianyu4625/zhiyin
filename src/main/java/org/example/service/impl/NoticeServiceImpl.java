package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.NoticeMapper;
import org.example.pojo.Notice;
import org.example.pojo.PageBean;
import org.example.service.NoticeService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public void addnotice(String content) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        noticeMapper.addnotice(userid,content);
    }

    @Override
    public void updateshow(Notice notice) {
        noticeMapper.updateshow(notice);
    }

    @Override
    public void updatenotice(Notice notice) {
        noticeMapper.updatenotice(notice);
    }

    @Override
    public PageBean<Notice> selectnotice(Integer pageNum, Integer pageSize, String content) {
        PageBean<Notice> pb=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Notice> notices=noticeMapper.selectnotice(content);
        PageInfo<Notice> pageInfo=new PageInfo<>(notices);
        pb.setItems(notices);
        pb.setTotal(pageInfo.getTotal());
        return pb;
    }
}
