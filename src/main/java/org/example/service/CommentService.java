package org.example.service;

import org.example.pojo.Comment;
import org.example.pojo.PageBean;

public interface CommentService {
    void addcomment(Integer suggestionid, String content);


    PageBean<Comment> selectcomment(Integer pageNum, Integer pageSize, Integer suggestionid);

    void deletecomment(Comment comment);
}
