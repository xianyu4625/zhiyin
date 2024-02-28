package org.example.service.impl;

import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import org.example.mapper.FeedbackMapper;
import org.example.pojo.Feedback;
import org.example.service.FeedbackService;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Override
    public void addfeedback(Feedback feedback) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer userid=(Integer) map.get("id");
        feedback.setUserid(userid);
        feedbackMapper.addfeedback(feedback);
    }

    @Override
    public List<Feedback> selectfeedback(Integer suggestionid) {
        List<Feedback> list=feedbackMapper.selectfeedback(suggestionid);
        return list;
    }

    @Override
    public void updatefeedback(Feedback feedback) {
        feedbackMapper.updatefeedback(feedback);
    }

    @Override
    public void deletefeedback(Feedback feedback) {
        feedbackMapper.deletefeedback(feedback);
    }
}
