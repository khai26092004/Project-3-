package org.hvk.hvk.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlller {

    @GetMapping("/")
    public String index(Model model) {
        // Lấy thông tin xác thực
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("Tên người dùng: " + authentication.getName());
        System.out.println("Đã xác thực: " + authentication.isAuthenticated());

        // Kiểm tra nếu người dùng đã đăng nhập
        if (authentication != null && authentication.isAuthenticated()
                && !authentication.getName().equals("anonymousUser")) {
            model.addAttribute("username", authentication.getName());
        } else {
            model.addAttribute("username", null);  // Không có người dùng đăng nhập
        }

        return "home/index";
    }
}

