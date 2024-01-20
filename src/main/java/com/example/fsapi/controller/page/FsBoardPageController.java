package com.example.fsapi.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fsboard")
@Controller
public class FsBoardPageController {
    @GetMapping("/{page}")
    public String create(@PathVariable("page") String page){
        return "/fsboard/" + page;
    }

}