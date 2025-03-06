package org.hvk.hvk.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.HocvienDTO;
import org.hvk.hvk.service.HocvienService;
import org.hvk.hvk.vo.HocvienQueryVO;
import org.hvk.hvk.vo.HocvienUpdateVO;
import org.hvk.hvk.vo.HocvienVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/hocvien")
public class HocvienController {

    @Autowired
    private HocvienService hocvienService;

    @PostMapping
    public String save(@Valid @RequestBody HocvienVO vO) {
        return hocvienService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        hocvienService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody HocvienUpdateVO vO) {
        hocvienService.update(id, vO);
    }

    @GetMapping("/{id}")
    public HocvienDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return hocvienService.getById(id);
    }

    @GetMapping
    public Page<HocvienDTO> query(@Valid HocvienQueryVO vO, Pageable pageable) {
        return hocvienService.query(vO, pageable);
    }
}
