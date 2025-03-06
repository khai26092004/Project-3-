package org.hvk.hvk.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.LophocDTO;
import org.hvk.hvk.service.LophocService;
import org.hvk.hvk.vo.LophocQueryVO;
import org.hvk.hvk.vo.LophocUpdateVO;
import org.hvk.hvk.vo.LophocVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/lophoc")
public class LophocController {

    @Autowired
    private LophocService lophocService;

    @PostMapping
    public String save(@Valid @RequestBody LophocVO vO) {
        return lophocService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        lophocService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody LophocUpdateVO vO) {
        lophocService.update(id, vO);
    }

    @GetMapping("/{id}")
    public LophocDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return lophocService.getById(id);
    }

    @GetMapping
    public Page<LophocDTO> query(@Valid LophocQueryVO vO, Pageable pageable) {
        return lophocService.query(vO, pageable);
    }
}
