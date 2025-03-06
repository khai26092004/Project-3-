package org.hvk.hvk.service;

import org.hvk.hvk.dto.GiangvienDTO;
import org.hvk.hvk.model.Giangvien;
import org.hvk.hvk.repository.GiangvienRepository;
import org.hvk.hvk.vo.GiangvienQueryVO;
import org.hvk.hvk.vo.GiangvienUpdateVO;
import org.hvk.hvk.vo.GiangvienVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GiangvienService {

    @Autowired
    private GiangvienRepository giangvienRepository;

    public Integer save(GiangvienVO vO) {
        Giangvien bean = new Giangvien();
        BeanUtils.copyProperties(vO, bean);
        bean = giangvienRepository.save(bean);
        return bean.getMaGiangVien();
    }

    public void delete(Integer id) {
        giangvienRepository.deleteById(id);
    }

    public void update(Integer id, GiangvienUpdateVO vO) {
        Giangvien bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        giangvienRepository.save(bean);
    }

    public GiangvienDTO getById(Integer id) {
        Giangvien original = requireOne(id);
        return toDTO(original);
    }

    public Page<GiangvienDTO> query(GiangvienQueryVO vO, Pageable pageable) {
        Page<Giangvien> pageResult = giangvienRepository.findAll(pageable);
        return pageResult.map(this::toDTO);
    }

    private GiangvienDTO toDTO(Giangvien original) {
        GiangvienDTO bean = new GiangvienDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Giangvien requireOne(Integer id) {
        return giangvienRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
