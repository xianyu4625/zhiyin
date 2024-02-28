package org.example.controller;

import org.example.pojo.Feedback;
import org.example.pojo.Result;
import org.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping("/addfeedback")
    public Result addfeedback(@RequestBody Feedback feedback){
        feedbackService.addfeedback(feedback);
        return Result.success();
    }
//    根据建议id来查找
    @GetMapping("/selectfeedback")
    public Result<List<Feedback>> selectfeedback(Integer suggestionid){
        List<Feedback> feedback=feedbackService.selectfeedback(suggestionid);
        return Result.success(feedback);
    }
//    更新反馈
    @PatchMapping("/updatefeedback")
    public Result updatefeedback(@RequestBody @Validated Feedback feedback){
        feedbackService.updatefeedback(feedback);
        return Result.success();
    }
    @PatchMapping("/deletefeedback")
    public Result deletefeedback(@RequestBody Feedback feedback){
        feedbackService.deletefeedback(feedback);
        return Result.success();
    }
}
