package org.hvk.hvk.service;

import org.hvk.hvk.dto.DangkyhocDTO;
import org.hvk.hvk.model.Dangkyhoc;
import org.hvk.hvk.repository.DangkyhocRepository;
import org.hvk.hvk.vo.DangkyhocQueryVO;
import org.hvk.hvk.vo.DangkyhocUpdateVO;
import org.hvk.hvk.vo.DangkyhocVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DangkyhocService {

    @Autowired
    private DangkyhocRepository dangkyhocRepository;

    public Integer save(DangkyhocVO vO) {
        Dangkyhoc bean = new Dangkyhoc();
        BeanUtils.copyProperties(vO, bean);
        bean = dangkyhocRepository.save(bean);
        return bean.getMaDangKy();
    }

    public void delete(Integer id) {
        dangkyhocRepository.deleteById(id);
    }

    public void update(Integer id, DangkyhocUpdateVO vO) {
        Dangkyhoc bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        dangkyhocRepository.save(bean);
    }

    public DangkyhocDTO getById(Integer id) {
        Dangkyhoc original = requireOne(id);
        return toDTO(original);
    }

    public Page<DangkyhocDTO> query(DangkyhocQueryVO vO, Pageable pageable) {
        Page<Dangkyhoc> pageResult = dangkyhocRepository.findAll(pageable);
        return pageResult.map(this::toDTO);
    }

    private DangkyhocDTO toDTO(Dangkyhoc original) {
        DangkyhocDTO bean = new DangkyhocDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Dangkyhoc requireOne(Integer id) {
        return dangkyhocRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
