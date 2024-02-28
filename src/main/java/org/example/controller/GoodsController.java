package org.example.controller;

import org.example.pojo.Goods;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.GoodService;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodService goodService;
    @PostMapping("/addgoods")
    public Result addgoods(@RequestBody @Validated Goods goods){
        goodService.add(goods);
        return Result.success();
    }
    @GetMapping("/selectgoods")
    public Result<List<Goods>> selectgoods(
//            Integer pageNum,
//            Integer pageSize,
            @RequestParam(required = false) String goodname,
            @RequestParam(required = false) Integer score
    ){
        List<Goods> goods=goodService.select(goodname,score);
        return Result.success(goods);
    }
    @PostMapping("/updategoods")
    public Result updategoods(@Validated @RequestBody Goods goods){
        goodService.updategoods(goods);
        return Result.success();
    }
    @PostMapping("/deletegoods")
    public Result deletegoods(@Validated @RequestBody Goods goods){
        goodService.deletegoods(goods);
        return Result.success();
    }
}
