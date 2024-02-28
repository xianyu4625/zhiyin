package org.example.service;

import org.example.pojo.PageBean;
import org.example.pojo.Suggestion;
import org.example.pojo.SuggestionView;

public interface SuggestionService {
    void addsuggestion(Suggestion suggestion);

    PageBean<SuggestionView> select(Integer pageNum, Integer pageSize, String username, String content);

    void updateshow(Suggestion suggestion);

    void deletesuggestion(Suggestion suggestion);

    PageBean<SuggestionView> selectself(Integer pageNum, Integer pageSize, String username, String content);

    Integer mount();
}
