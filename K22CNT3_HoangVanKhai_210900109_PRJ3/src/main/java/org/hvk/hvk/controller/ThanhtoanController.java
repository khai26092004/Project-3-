package org.hvk.hvk.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.ThanhtoanDTO;
import org.hvk.hvk.service.ThanhtoanService;
import org.hvk.hvk.vo.ThanhtoanQueryVO;
import org.hvk.hvk.vo.ThanhtoanUpdateVO;
import org.hvk.hvk.vo.ThanhtoanVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/thanhtoan")
public class ThanhtoanController {

    @Autowired
    private ThanhtoanService thanhtoanService;

    @PostMapping
    public String save(@Valid @RequestBody ThanhtoanVO vO) {
        return thanhtoanService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        thanhtoanService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ThanhtoanUpdateVO vO) {
        thanhtoanService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ThanhtoanDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return thanhtoanService.getById(id);
    }

    @GetMapping
    public Page<ThanhtoanDTO> query(@Valid ThanhtoanQueryVO vO, Pageable pageable) {
        return thanhtoanService.query(vO,pageable );
    }
}
