package org.hvk.hvk.controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hvk.hvk.dto.GiangvienDTO;
import org.hvk.hvk.service.GiangvienService;
import org.hvk.hvk.vo.GiangvienQueryVO;
import org.hvk.hvk.vo.GiangvienUpdateVO;
import org.hvk.hvk.vo.GiangvienVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/giangvien")
public class GiangvienController {

    @Autowired
    private GiangvienService giangvienService;

    @PostMapping
    public String save(@Valid @RequestBody GiangvienVO vO) {
        return giangvienService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        giangvienService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody GiangvienUpdateVO vO) {
        giangvienService.update(id, vO);
    }

    @GetMapping("/{id}")
    public GiangvienDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return giangvienService.getById(id);
    }

    @GetMapping
    public Page<GiangvienDTO> query(@Valid GiangvienQueryVO vO, Pageable pageable) {
        return giangvienService.query(vO, pageable);
    }
}
