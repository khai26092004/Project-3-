package org.hvk.hvk.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlller {
    @GetMapping("/")
    public String index(Model model) {
        return "home/index";
    }

}
