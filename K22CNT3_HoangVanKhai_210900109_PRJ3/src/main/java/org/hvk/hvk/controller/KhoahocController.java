package org.hvk.hvk.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.KhoahocDTO;
import org.hvk.hvk.model.Khoahoc;
import org.hvk.hvk.service.KhoahocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("admin/khoahoc")
public class KhoahocController {

    @Autowired
    private KhoahocService khoahocService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public String viewKhoahoc(Model model) {
        List<Khoahoc> listKhoahoc = khoahocService.getKhoahocList();
        model.addAttribute("list_khoahoc", listKhoahoc);
        return "admin/khoahoc/index";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        Khoahoc khoahoc = new Khoahoc();
        model.addAttribute("khoahoc", khoahoc);
        return "admin/khoahoc/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("khoahoc") KhoahocDTO khoahocDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/khoahoc/create";
        }
        if (khoahocService.save(khoahocDTO)) {
            return "redirect:/admin/khoahoc";
        }
        return "redirect:/admin/khoahoc/create?error=true";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @Valid @PathVariable("id") Integer id) {
        Khoahoc khoahoc = khoahocService.findById(id);
        model.addAttribute("khoahoc", khoahoc);
        return "admin/khoahoc/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
                         @Valid @ModelAttribute("khoahoc") KhoahocDTO khoahocDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/khoahoc/edit";
        }
        khoahocService.update(id, khoahocDTO);
        return "redirect:/admin/khoahoc";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        khoahocService.delete(id);
        return "redirect:/admin/khoahoc";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/show/{id}")
    public String show(Model model, @Valid @PathVariable("id") Integer id) {
        Khoahoc khoahoc = khoahocService.findById(id);
        model.addAttribute("khoahoc", khoahoc);
        return "admin/khoahoc/show";
    }
}