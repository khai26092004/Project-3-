package org.hvk.hvk.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.GiangvienDTO;

import org.hvk.hvk.model.Giangvien;

import org.hvk.hvk.service.GiangvienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("admin/giangvien")
public class GiangvienController {

    @Autowired
    private GiangvienService GiangvienService;
    
    @GetMapping
    public String viewGiangVien(Model model) {
        List<Giangvien> listGiangVien = GiangvienService.getGiangVienList();
        model.addAttribute("list_giangvien", listGiangVien);
        return "admin/giangvien/index";
    }


    @RequestMapping("/create")
    public String create(Model model) {
        Giangvien Giangvien = new Giangvien();
        model.addAttribute("giangvien", Giangvien);
        return "admin/giangvien/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("giangvien") GiangvienDTO GiangvienDTO) {
        if(GiangvienService.save(GiangvienDTO)){
            return "redirect:/admin/giangvien";
        }
        return "redirect:/admin/giangvien/create?error=true";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @Valid @PathVariable("id") Integer id) {
        Giangvien giangvien = GiangvienService.findById(id);
        model.addAttribute("giangvien", giangvien);
        return "admin/giangvien/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
                         @ModelAttribute("giangvien") GiangvienDTO GiangvienDTO) {
        GiangvienService.update(id, GiangvienDTO);
        return "redirect:/admin/giangvien";
    }

    @GetMapping("/delete/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        GiangvienService.delete(id);
        return "redirect:/admin/giangvien";
    }

    @GetMapping("/show/{id}")
    public String show(Model model, @Valid @PathVariable("id") Integer id) {
        Giangvien giangvien = GiangvienService.findById(id);
        model.addAttribute("giangvien", giangvien);
        return "admin/giangvien/show";
    }
}
