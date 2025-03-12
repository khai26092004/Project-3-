package org.hvk.hvk.controller;

import org.hvk.hvk.model.Nguoidung;
import org.hvk.hvk.model.VaiTro;
import org.hvk.hvk.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class AuthController {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("tennguoidung") String tennguoidung,
                           @RequestParam("tendangnhap") String tendangnhap,
                           @RequestParam("email") String email,
                           @RequestParam("matkhau") String matkhau,
                           Model model) {
        // Kiểm tra xem tendangnhap đã tồn tại chưa
        if (nguoiDungRepository.findByTendangnhap(tendangnhap).isPresent()) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "register";
        }

        // Tạo người dùng mới
        Nguoidung nguoidung = new Nguoidung();
        nguoidung.setTennguoidung(tennguoidung);
        nguoidung.setTendangnhap(tendangnhap);
        nguoidung.setEmail(email);
        nguoidung.setMatkhau(passwordEncoder.encode(matkhau)); // Mã hóa mật khẩu
        nguoidung.setVaitro(VaiTro.STUDENT); // Mặc định là STUDENT

        // Lưu vào database
        nguoiDungRepository.save(nguoidung);

        // Đăng nhập tự động
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                tendangnhap,
                matkhau,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+nguoidung.getVaitro().name()))
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Chuyển hướng thủ công
        if (nguoidung.getVaitro() == VaiTro.ADMIN) {
            return "redirect:/admin";
        } else {
            return "redirect:/";
        }
    }

    // Thêm endpoint kiểm tra thủ công
    @PostMapping("/manual-login")
    public String manualLogin(@RequestParam("tendangnhap") String tendangnhap,
                              @RequestParam("matkhau") String matkhau,
                              Model model) {
        // Tìm người dùng trong database
        Nguoidung nguoidung = nguoiDungRepository.findByTendangnhap(tendangnhap)
                .orElse(null);

        // Kiểm tra xem người dùng có tồn tại không
        if (nguoidung == null) {
            model.addAttribute("error", "Tên đăng nhập không tồn tại!");
            return "login"; // Trả về trang login với thông báo lỗi
        }

        // So sánh mật khẩu plaintext với mật khẩu mã hóa trong database
        if (!passwordEncoder.matches(matkhau, nguoidung.getMatkhau())) {
            model.addAttribute("error", "Mật khẩu không đúng!");
            return "login"; // Trả về trang login với thông báo lỗi
        }

        // Nếu xác thực thành công, thiết lập phiên đăng nhập
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                nguoidung.getTendangnhap(),
                nguoidung.getMatkhau(),
                Collections.singletonList(new SimpleGrantedAuthority(nguoidung.getVaitro().name()))
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Chuyển hướng dựa trên vai trò
        if (nguoidung.getVaitro() == VaiTro.ADMIN) {
            return "redirect:/admin";
        } else {
            return "redirect:/";
        }
    }
}