package org.example.controller;

import org.example.pojo.Result;
import org.example.service.ScoreService;
import org.example.service.Userservice;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Validated
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private Userservice userservice;
    @PostMapping("/addscore")
    public Result addscore(Integer id,Integer score){
        scoreService.add(id,score);
        return Result.success();
    }
    @PostMapping("/update")
    public Result updatescore(Integer score){
        Map<String,Object> user = ThreadLocalUtil.get();
        Integer id=(Integer) user.get("id");
        scoreService.update(id,score);
        userservice.updatescore(id,score);
        return Result.success();
    }
}
