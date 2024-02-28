package org.example.service;

import org.example.pojo.Feedback;

import java.util.List;

public interface FeedbackService {
    void addfeedback(Feedback feedback);

    List<Feedback> selectfeedback(Integer suggestionid);

    void updatefeedback(Feedback feedback);

    void deletefeedback(Feedback feedback);
}
