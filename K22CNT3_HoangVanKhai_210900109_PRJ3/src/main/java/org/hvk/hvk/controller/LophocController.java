package org.hvk.hvk.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.LophocDTO;
import org.hvk.hvk.model.Lophoc;
import org.hvk.hvk.service.LophocService;
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
@RequestMapping("admin/lophoc")
public class LophocController {

    @Autowired
    private LophocService lophocService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public String viewLophoc(Model model) {
        List<Lophoc> listLophoc = lophocService.getLophocList();
        model.addAttribute("list_lophoc", listLophoc);
        return "admin/lophoc/index";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model) {
        Lophoc lophoc = new Lophoc();
        model.addAttribute("lophoc", lophoc);
        return "admin/lophoc/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("lophoc") LophocDTO lophocDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/lophoc/create";
        }
        if (lophocService.save(lophocDTO)) {
            return "redirect:/admin/lophoc";
        }
        return "redirect:/admin/lophoc/create?error=true";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @Valid @PathVariable("id") Integer id) {
        Lophoc lophoc = lophocService.findById(id);
        model.addAttribute("lophoc", lophoc);
        return "admin/lophoc/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
                         @Valid @ModelAttribute("lophoc") LophocDTO lophocDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/lophoc/edit";
        }
        lophocService.update(id, lophocDTO);
        return "redirect:/admin/lophoc";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        lophocService.delete(id);
        return "redirect:/admin/lophoc";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/show/{id}")
    public String show(Model model, @Valid @PathVariable("id") Integer id) {
        Lophoc lophoc = lophocService.findById(id);
        model.addAttribute("lophoc", lophoc);
        return "admin/lophoc/show";
    }
}