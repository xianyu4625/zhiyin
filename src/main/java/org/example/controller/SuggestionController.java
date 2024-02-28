package org.example.controller;

import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.pojo.Suggestion;
import org.example.pojo.SuggestionView;
import org.example.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/suggestion")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;
    @PostMapping("/addsuggestion")
    public Result addsuggestion(@RequestBody @Validated Suggestion suggestion){
        suggestionService.addsuggestion(suggestion);
        return Result.success();
    }
//    查看所有建议
    @GetMapping("selectSuggestion")
    public Result<PageBean<SuggestionView>> selectSuggestion(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String content
    ){
        PageBean<SuggestionView> suggestion=suggestionService.select(pageNum,pageSize,username,content);
        return Result.success(suggestion);
    }
    @PatchMapping("/updateshow")
    public Result updateshow(@RequestBody Suggestion suggestion){
        suggestionService.updateshow(suggestion);
        return Result.success();
    }
    @PatchMapping("/deletesuggestion")
    public Result deletesuggestion(@RequestBody Suggestion suggestion){
//        System.out.println("test"+suggestion);
        suggestionService.deletesuggestion(suggestion);
        return Result.success();
    }
//    查看个人建议
    @GetMapping("selectselfSuggestion")
    public Result<PageBean<SuggestionView>> selectselfSuggestion(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String content
    ){
        PageBean<SuggestionView> suggestion=suggestionService.selectself(pageNum,pageSize,username,content);
        return Result.success(suggestion);
    }
//    统计所有的建议数
    @GetMapping("mount")
    public Result mount(){
        Integer mount=suggestionService.mount();
        return Result.success(mount);
        }
}
