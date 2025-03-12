package org.hvk.hvk.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.DangkyhocDTO;
import org.hvk.hvk.model.Dangkyhoc;
import org.hvk.hvk.service.DangkyhocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("admin/dangkyhoc")
public class DangkyhocController {

    @Autowired
    private DangkyhocService dangkyhocService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public String viewDangKyHoc(Model model) {
        List<Dangkyhoc> listDangKyHoc = dangkyhocService.getDangkyhocList();
        model.addAttribute("list_dangkyhoc", listDangKyHoc);
        return "admin/dangkyhoc/index";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("/create")
    public String create(Model model) {
        Dangkyhoc dangkyhoc = new Dangkyhoc();
        model.addAttribute("dangkyhoc", dangkyhoc);
        return "admin/dangkyhoc/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("dangkyhoc") DangkyhocDTO dangkyhocDTO) {
        if(dangkyhocService.save(dangkyhocDTO)){
            return "redirect:/admin/dangkyhoc";
        }
        return "redirect:/admin/dangkyhoc/create?error=true";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @Valid @PathVariable("id") Integer id) {
        Dangkyhoc dangkyhoc = dangkyhocService.findById(id);
        model.addAttribute("dangkyhoc", dangkyhoc);
        return "admin/dangkyhoc/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
                         @ModelAttribute("dangkyhoc") DangkyhocDTO dangkyhocDTO) {
        dangkyhocService.update(id, dangkyhocDTO);
        return "redirect:/admin/dangkyhoc";
    }

    @GetMapping("/delete/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        dangkyhocService.delete(id);
        return "redirect:/admin/dangkyhoc";
    }

    @GetMapping("/show/{id}")
    public String show(Model model, @Valid @PathVariable("id") Integer id) {
        Dangkyhoc dangkyhoc = dangkyhocService.findById(id);
        model.addAttribute("dangkyhoc", dangkyhoc);
        return "admin/dangkyhoc/show";
    }
}
