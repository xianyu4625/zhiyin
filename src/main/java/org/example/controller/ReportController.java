package org.example.controller;

import org.example.pojo.*;
import org.example.service.ReportService;
import org.example.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
//    系统添加举报
    @PostMapping("/addreport")
    public Result addreport(@RequestBody @Validated Report report){
        reportService.addreport(report);
        return Result.success();
    }
//    删除举报
    @PatchMapping("/deletereport")
    public Result deleterepoet(@RequestBody Report report){
        reportService.deletereport(report);
        return Result.success();
    }
//    是否展示
    @PatchMapping("/showreport")
    public Result showreport(@RequestBody Report report){
        reportService.show(report);
        return Result.success();
    }
//    @PostMapping("/selectreport")
//    public Result<PageBean<ReportView>> selectreport(
//            Integer pageNum,
//            Integer pageSize,
//            @RequestParam(required = false) String nickname,
//            @RequestParam(required = false) String contents
//    ){
//        PageBean<ReportView> report=reportService.selectreport(pageNum,pageSize,nickname,contents);
//        return Result.success(report);
//    }

//    查看所有的举报信息
    @GetMapping("/selectreport")
    public Result<PageBean<ReportView>> selectReport(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) String contents
    ){
        PageBean<ReportView> report=reportService.selectReport(pageNum,pageSize,nickname,contents);
        return Result.success(report);
    }
//    查看个人的举报信息
    @GetMapping("/selectselfreport")
    public Result<PageBean<ReportView>> selectselfReport(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) String contents
    ){
        PageBean<ReportView> report=reportService.selectselfReport(pageNum,pageSize,nickname,contents);
        return Result.success(report);
    }
}
