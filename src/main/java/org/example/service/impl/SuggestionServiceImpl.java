package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.SuggestionMapper;
import org.example.pojo.PageBean;
import org.example.pojo.Suggestion;
import org.example.pojo.SuggestionView;
import org.example.service.SuggestionService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionMapper suggestionMapper;

    @Override
    public void addsuggestion(Suggestion suggestion) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        suggestion.setUserid(userid);
        suggestionMapper.addsuggestion(suggestion);
    }

    @Override
    public PageBean<SuggestionView> select(Integer pageNum, Integer pageSize, String username, String content) {
        // 设置分页参数
        PageHelper pageHelper=new PageHelper();
        pageHelper.startPage(pageNum, pageSize);

        PageBean<SuggestionView> suggestion = new PageBean<>();
        Integer pageNums=(pageNum-1)*pageSize;
        List<SuggestionView> sugg = suggestionMapper.selected(username, content,pageNums,pageSize);

        PageInfo<SuggestionView> pageInfo = new PageInfo<>(sugg);
        suggestion.setTotal(pageInfo.getTotal());
        suggestion.setItems(sugg);

        return suggestion;
    }


    @Override
    public void updateshow(Suggestion suggestion) {
        suggestionMapper.updateshow(suggestion);
    }

    @Override
    public void deletesuggestion(Suggestion suggestion) {
        suggestionMapper.deletesuggestion(suggestion);
    }

    @Override
    public PageBean<SuggestionView> selectself(Integer pageNum, Integer pageSize, String username, String content) {
        PageBean<SuggestionView> suggestion=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        List<SuggestionView> sugg= suggestionMapper.selectself(userid,username,content);
        PageInfo<SuggestionView> pageInfo=new PageInfo<>(sugg);
        suggestion.setTotal(pageInfo.getTotal());
        suggestion.setItems(sugg);
        return suggestion;
    }

    @Override
    public Integer mount() {
        Integer mount=suggestionMapper.mount();
        return mount;
    }
}
