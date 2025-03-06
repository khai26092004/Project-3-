package org.hvk.hvk.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.KhoahocDTO;
import org.hvk.hvk.service.KhoahocService;
import org.hvk.hvk.vo.KhoahocQueryVO;
import org.hvk.hvk.vo.KhoahocUpdateVO;
import org.hvk.hvk.vo.KhoahocVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/khoahoc")
public class KhoahocController {

    @Autowired
    private KhoahocService khoahocService;

    @PostMapping
    public String save(@Valid @RequestBody KhoahocVO vO) {
        return khoahocService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        khoahocService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody KhoahocUpdateVO vO) {
        khoahocService.update(id, vO);
    }

    @GetMapping("/{id}")
    public KhoahocDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return khoahocService.getById(id);
    }

    @GetMapping
    public Page<KhoahocDTO> query(@Valid KhoahocQueryVO vO, Pageable pageable   ) {
        return khoahocService.query(vO,pageable);
    }
}
