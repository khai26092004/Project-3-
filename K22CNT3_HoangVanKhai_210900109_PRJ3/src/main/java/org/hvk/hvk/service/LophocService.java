package org.hvk.hvk.service;

import org.hvk.hvk.dto.LophocDTO;
import org.hvk.hvk.model.Lophoc;
import org.hvk.hvk.repository.LophocRepository;
import org.hvk.hvk.vo.LophocQueryVO;
import org.hvk.hvk.vo.LophocUpdateVO;
import org.hvk.hvk.vo.LophocVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LophocService {

    @Autowired
    private LophocRepository lophocRepository;

    public Integer save(LophocVO vO) {
        Lophoc bean = new Lophoc();
        BeanUtils.copyProperties(vO, bean);
        bean = lophocRepository.save(bean);
        return bean.getMaLopHoc();
    }

    public void delete(Integer id) {
        lophocRepository.deleteById(id);
    }

    public void update(Integer id, LophocUpdateVO vO) {
        Lophoc bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        lophocRepository.save(bean);
    }

    public LophocDTO getById(Integer id) {
        Lophoc original = requireOne(id);
        return toDTO(original);
    }

    public Page<LophocDTO> query(LophocQueryVO vO, Pageable pageable) {
        Page<Lophoc> pageResult = lophocRepository.findAll(pageable);
        return pageResult.map(this::toDTO);
    }

    private LophocDTO toDTO(Lophoc original) {
        LophocDTO bean = new LophocDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Lophoc requireOne(Integer id) {
        return lophocRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
