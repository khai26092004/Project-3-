package org.hvk.hvk.service;

import org.hvk.hvk.dto.HocvienDTO;
import org.hvk.hvk.model.Hocvien;
import org.hvk.hvk.repository.HocvienRepository;
import org.hvk.hvk.vo.HocvienQueryVO;
import org.hvk.hvk.vo.HocvienUpdateVO;
import org.hvk.hvk.vo.HocvienVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class HocvienService {

    @Autowired
    private HocvienRepository hocvienRepository;

    public Integer save(HocvienVO vO) {
        Hocvien bean = new Hocvien();
        BeanUtils.copyProperties(vO, bean);
        bean = hocvienRepository.save(bean);
        return bean.getMaHocVien();
    }

    public void delete(Integer id) {
        hocvienRepository.deleteById(id);
    }

    public void update(Integer id, HocvienUpdateVO vO) {
        Hocvien bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        hocvienRepository.save(bean);
    }

    public HocvienDTO getById(Integer id) {
        Hocvien original = requireOne(id);
        return toDTO(original);
    }

    public Page<HocvienDTO> query(HocvienQueryVO vO, Pageable pageable) {
        Page<Hocvien> pageResult = hocvienRepository.findAll(pageable);
        return pageResult.map(this::toDTO);
    }

    private HocvienDTO toDTO(Hocvien original) {
        HocvienDTO bean = new HocvienDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Hocvien requireOne(Integer id) {
        return hocvienRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
