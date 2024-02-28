package org.example.service;

import org.example.pojo.Notice;
import org.example.pojo.PageBean;

public interface NoticeService {
    void addnotice(String content);

    void updateshow(Notice notice);

    void updatenotice(Notice notice);

    PageBean<Notice> selectnotice(Integer pageNum, Integer pageSize, String content);
}
