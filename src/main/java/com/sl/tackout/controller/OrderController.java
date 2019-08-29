package com.sl.tackout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by happy on 2019/8/27.
 */
@Controller
public class OrderController {

    @RequestMapping("showOrder")
    public String showOrder(){
        return "order";
    }

}
