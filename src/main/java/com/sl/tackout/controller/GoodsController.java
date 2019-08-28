package com.sl.tackout.controller;

import com.sl.tackout.pojo.Goods;
import com.sl.tackout.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = false,defaultValue = "1")int page,
                          @RequestParam(required = false,defaultValue = "1")int rows,
                          Model model){
        int maxPage=goodsService.findcount(rows);

        if(page>maxPage){
            page=1;
        }
        if(page<1){
            page=maxPage;
        }

        List<Goods> goodsList=goodsService.findAll(page,rows);
        model.addAttribute("goodsList",goodsList);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "zhanshi";
    }
}
