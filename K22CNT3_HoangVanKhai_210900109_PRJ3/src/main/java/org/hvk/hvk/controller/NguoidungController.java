package org.hvk.hvk.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.NguoidungDTO;
import org.hvk.hvk.model.Nguoidung;
import org.hvk.hvk.service.NguoidungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("admin/nguoidung")
public class NguoidungController {

    @Autowired
    private NguoidungService nguoidungService;

    @GetMapping
    public String viewNguoidung(Model model) {
        List<Nguoidung> listNguoidung = nguoidungService.getNguoidungList();
        model.addAttribute("list_nguoidung", listNguoidung);
        return "admin/nguoidung/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Nguoidung nguoidung = new Nguoidung();
        model.addAttribute("nguoidung", nguoidung);
        return "admin/nguoidung/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("nguoidung") NguoidungDTO nguoidungDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/nguoidung/create";
        }
        if (nguoidungService.save(nguoidungDTO)) {
            return "redirect:/admin/nguoidung";
        }
        return "redirect:/admin/nguoidung/create?error=true";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @Valid @PathVariable("id") Integer id) {
        Nguoidung nguoidung = nguoidungService.findById(id);
        model.addAttribute("nguoidung", nguoidung);
        return "admin/nguoidung/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
                         @Valid @ModelAttribute("nguoidung") NguoidungDTO nguoidungDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/nguoidung/edit";
        }
        nguoidungService.update(id, nguoidungDTO);
        return "redirect:/admin/nguoidung";
    }

    @GetMapping("/delete/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        nguoidungService.delete(id);
        return "redirect:/admin/nguoidung";
    }

    @GetMapping("/show/{id}")
    public String show(Model model, @Valid @PathVariable("id") Integer id) {
        Nguoidung nguoidung = nguoidungService.findById(id);
        model.addAttribute("nguoidung", nguoidung);
        return "admin/nguoidung/show";
    }
}