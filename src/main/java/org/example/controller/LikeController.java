package org.example.controller;

import org.example.pojo.Like;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;
    @PostMapping("addlike")
    public Result addlike(@RequestBody Like like){
        likeService.addlike(like);
        return Result.success();
    }
//    分页模糊查询点赞的信息
    @GetMapping("/showlike")
    public Result<PageBean<Like>> showlike(
            Integer pageNum,
            Integer pageSize,
            Integer suggestionid
    ){
        PageBean<Like> like= likeService.showlike(pageNum,pageSize,suggestionid);
        return Result.success(like);
    }
//    删除点赞信息
    @PatchMapping("/deletelike")
    public Result deletelike(@RequestBody Like like){
        likeService.deletelike(like);
        return Result.success();
    }
}
