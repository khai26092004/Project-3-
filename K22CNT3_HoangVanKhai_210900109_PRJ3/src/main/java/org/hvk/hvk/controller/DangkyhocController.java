package org.hvk.hvk.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.DangkyhocDTO;
import org.hvk.hvk.service.DangkyhocService;
import org.hvk.hvk.vo.DangkyhocQueryVO;
import org.hvk.hvk.vo.DangkyhocUpdateVO;
import org.hvk.hvk.vo.DangkyhocVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("admin/dangkyhoc")
public class DangkyhocController {

    @Autowired
    private DangkyhocService dangkyhocService;

    @GetMapping
    public String index() {
        return "admin/dangkyhoc/index";
    }

    @PostMapping
    public String save(@Valid @RequestBody DangkyhocVO vO) {
        return dangkyhocService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        dangkyhocService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody DangkyhocUpdateVO vO) {
        dangkyhocService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DangkyhocDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return dangkyhocService.getById(id);
    }


}
