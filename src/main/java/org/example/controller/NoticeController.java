package org.example.controller;

import org.example.pojo.Notice;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @PostMapping("/addnotice")
    public Result addnotice(String content){
        noticeService.addnotice(content);
        return Result.success();
    }
//    是否展示
    @PatchMapping("/updateshow")
    public Result updateshow(@RequestBody Notice notice){
        noticeService.updateshow(notice);
        return Result.success();
    }
//更新公告
    @PatchMapping("/updatenotice")
    public Result updatenotice(@RequestBody @Validated Notice notice){
        noticeService.updatenotice(notice);
        return Result.success();
    }
//分页模糊查询公告
    @GetMapping("/selectnotice")
    public Result<PageBean<Notice>> selectnotice(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String content
    ){
        PageBean<Notice> notice=noticeService.selectnotice(pageNum,pageSize,content);
        return Result.success(notice);
    }
}
