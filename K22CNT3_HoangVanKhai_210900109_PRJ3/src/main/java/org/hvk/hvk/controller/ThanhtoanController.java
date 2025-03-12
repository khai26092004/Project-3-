package org.hvk.hvk.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.ThanhtoanDTO;
import org.hvk.hvk.model.Thanhtoan;
import org.hvk.hvk.service.ThanhtoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("admin/thanhtoan")
public class ThanhtoanController {

    @Autowired
    private ThanhtoanService thanhtoanService;

    @GetMapping
    public String viewThanhtoan(Model model) {
        List<Thanhtoan> listThanhtoan = thanhtoanService.getThanhtoanList();
        model.addAttribute("list_thanhtoan", listThanhtoan);
        return "admin/thanhtoan/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Thanhtoan thanhtoan = new Thanhtoan();
        model.addAttribute("thanhtoan", thanhtoan);
        return "admin/thanhtoan/create";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("thanhtoan") ThanhtoanDTO thanhtoanDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/thanhtoan/create";
        }
        if (thanhtoanService.save(thanhtoanDTO)) {
            return "redirect:/admin/thanhtoan";
        }
        return "redirect:/admin/thanhtoan/create?error=true";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @Valid @PathVariable("id") Integer id) {
        Thanhtoan thanhtoan = thanhtoanService.findById(id);
        model.addAttribute("thanhtoan", thanhtoan);
        return "admin/thanhtoan/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Integer id,
                         @Valid @ModelAttribute("thanhtoan") ThanhtoanDTO thanhtoanDTO,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/thanhtoan/edit";
        }
        thanhtoanService.update(id, thanhtoanDTO);
        return "redirect:/admin/thanhtoan";
    }

    @GetMapping("/delete/{id}")
    public String delete(@Valid @NotNull @PathVariable("id") Integer id) {
        thanhtoanService.delete(id);
        return "redirect:/admin/thanhtoan";
    }

    @GetMapping("/show/{id}")
    public String show(Model model, @Valid @PathVariable("id") Integer id) {
        Thanhtoan thanhtoan = thanhtoanService.findById(id);
        model.addAttribute("thanhtoan", thanhtoan);
        return "admin/thanhtoan/show";
    }
}