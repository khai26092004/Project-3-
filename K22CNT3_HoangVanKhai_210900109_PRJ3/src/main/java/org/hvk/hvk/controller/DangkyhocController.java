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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/dangkyhoc")
public class DangkyhocController {

    @Autowired
    private DangkyhocService dangkyhocService;

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

    @GetMapping
    public Page<DangkyhocDTO> query(@Valid DangkyhocQueryVO vO, Pageable pageable) {
        return dangkyhocService.query(vO, pageable);
    }
}
