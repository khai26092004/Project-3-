package org.hvk.hvk.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.HocvienDTO;
import org.hvk.hvk.model.Hocvien;
import org.hvk.hvk.service.HocvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("admin/hocvien")
public class HocvienController {

    @Autowired
    private HocvienService hocvienService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public String viewHocVien(Model model) {
        List<Hocvien> listHocVien = hocvienService.getHocvienList();
        model.addAttribute("list_hocvien", listHocVien);
        return "admin/hocvien/index";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        Hocvien hocvien = new Hocvien();
        model.addAttribute("hocvien", hocvien);
        return "admin/hocvien/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("hocvien") HocvienDTO hocvienDTO) {
        if (hocvienService.save(hocvienDTO)) {
            return "redirect:/admin/hocvien";
        }
        return "redirect:/admin/hocvien/create?error=true";
    }

    @PostMapping("/add")
    public String saveHv(@Valid @ModelAttribute("hocvien") HocvienDTO hocvienDTO) {
        if (hocvienService.save(hocvienDTO)) {
            return "redirect:/?dang ky thanh cong";
        }
        return "redirect:/?taosai";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @Valid @PathVariable("id") Integer id) {
        Hocvien hocvien = hocvienService.findById(id);
        model.addAttribute("hocvien", hocvien);
        return "admin/hocvien/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("hocvien") HocvienDTO hocvienDTO) {
        hocvienService.update(id, hocvienDTO);
        return "redirect:/admin/hocvien";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        hocvienService.delete(id);
        return "redirect:/admin/hocvien";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/show/{id}")
    public String show(Model model, @Valid @PathVariable("id") Integer id) {
        Hocvien hocvien = hocvienService.findById(id);
        model.addAttribute("hocvien", hocvien);
        return "admin/hocvien/show";
    }
}