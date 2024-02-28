package org.example.service.impl;

import org.example.mapper.ScoreMapper;
import org.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public void add(Integer id, Integer score) {
        scoreMapper.add(id,score);
    }

    @Override
    public void update(Integer id, Integer score) {
        scoreMapper.update(id,score);
    }
}
