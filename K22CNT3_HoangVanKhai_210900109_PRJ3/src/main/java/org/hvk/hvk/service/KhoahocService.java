package org.hvk.hvk.service;

import org.hvk.hvk.dto.KhoahocDTO;
import org.hvk.hvk.model.Khoahoc;
import org.hvk.hvk.repository.KhoahocRepository;
import org.hvk.hvk.vo.KhoahocQueryVO;
import org.hvk.hvk.vo.KhoahocUpdateVO;
import org.hvk.hvk.vo.KhoahocVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class KhoahocService {

    @Autowired
    private KhoahocRepository khoahocRepository;

    public Integer save(KhoahocVO vO) {
        Khoahoc bean = new Khoahoc();
        BeanUtils.copyProperties(vO, bean);
        bean = khoahocRepository.save(bean);
        return bean.getMaKhoaHoc();
    }

    public void delete(Integer id) {
        khoahocRepository.deleteById(id);
    }

    public void update(Integer id, KhoahocUpdateVO vO) {
        Khoahoc bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        khoahocRepository.save(bean);
    }

    public KhoahocDTO getById(Integer id) {
        Khoahoc original = requireOne(id);
        return toDTO(original);
    }

    public Page<KhoahocDTO> query(KhoahocQueryVO vO, Pageable pageable  ) {
        Page<Khoahoc> pageResult = khoahocRepository.findAll(pageable);
        return pageResult.map(this::toDTO);
    }

    private KhoahocDTO toDTO(Khoahoc original) {
        KhoahocDTO bean = new KhoahocDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Khoahoc requireOne(Integer id) {
        return khoahocRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
