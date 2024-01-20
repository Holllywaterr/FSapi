package com.example.fsapi.controller.page;

import org.springframework.web.bind.annotation.GetMapping;

    public class DefaultPageController {

        @GetMapping("/doc")
        public String getSwagger() {
            return "redirect:/swagger-ui/index.html";
        }

        @GetMapping({"", "/", "/index"})
        public String getIndex(){
            return "index";
        }
}
