package org.hvk.hvk.controller;

import org.hvk.hvk.model.Thanhtoan;
import org.hvk.hvk.repository.HocvienRepository;
import org.hvk.hvk.repository.KhoahocRepository;
import org.hvk.hvk.repository.DangkyhocRepository;
import org.hvk.hvk.repository.ThanhtoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private HocvienRepository hocvienRepository;

    @Autowired
    private KhoahocRepository khoahocRepository;

    @Autowired
    private DangkyhocRepository dangkyhocRepository;

    @Autowired
    private ThanhtoanRepository thanhtoanRepository;

    @GetMapping("/admin")
    public String dashboard(Model model) {
        // Add counts to the model
        model.addAttribute("totalHocVien", hocvienRepository.count());
        model.addAttribute("totalKhoaHoc", khoahocRepository.count());
        model.addAttribute("totalDangKyHoc", dangkyhocRepository.count());
        model.addAttribute("totalThanhToan", thanhtoanRepository.count());

        // Add recent payments (e.g., last 5)
        List<Thanhtoan> recentThanhToan = thanhtoanRepository.findTop5ByOrderByNgayThanhToanDesc();
        model.addAttribute("recentThanhToan", recentThanhToan);

        return "admin/index"; // Points to your Thymeleaf template
    }
}