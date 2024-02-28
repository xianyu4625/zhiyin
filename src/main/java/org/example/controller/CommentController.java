package org.example.controller;

import org.example.pojo.Comment;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/addcomment")
    public Result addcomment(Integer suggestionid,String content){
        commentService.addcomment(suggestionid,content);
        return Result.success();
    }
//    根据suggestionid来查找评论
    @GetMapping("/selectcomment")
    public Result<PageBean<Comment>> selectcomment(
            Integer pageNum,
            Integer pageSize,
            Integer suggestionid){
        PageBean<Comment> comment=commentService.selectcomment(pageNum,pageSize,suggestionid);
        return Result.success(comment);
    }
//    删除评论
    @PatchMapping("/deletecomment")
    public Result deletecomment(@RequestBody Comment comment){
        commentService.deletecomment(comment);
        return Result.success();
    }
}
