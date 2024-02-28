package org.example.service;

import org.example.pojo.Like;
import org.example.pojo.PageBean;

public interface LikeService {
    void addlike(Like like);

    PageBean<Like> showlike(Integer pageNum, Integer pageSize,Integer suggestionid);

    void deletelike(Like like);
}
