package org.hvk.hvk.service;

import org.hvk.hvk.dto.ThanhtoanDTO;
import org.hvk.hvk.model.Thanhtoan;
import org.hvk.hvk.repository.ThanhtoanRepository;
import org.hvk.hvk.vo.ThanhtoanQueryVO;
import org.hvk.hvk.vo.ThanhtoanUpdateVO;
import org.hvk.hvk.vo.ThanhtoanVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ThanhtoanService {

    @Autowired
    private ThanhtoanRepository thanhtoanRepository;

    public Integer save(ThanhtoanVO vO) {
        Thanhtoan bean = new Thanhtoan();
        BeanUtils.copyProperties(vO, bean);
        bean = thanhtoanRepository.save(bean);
        return bean.getMaThanhToan();
    }

    public void delete(Integer id) {
        thanhtoanRepository.deleteById(id);
    }

    public void update(Integer id, ThanhtoanUpdateVO vO) {
        Thanhtoan bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        thanhtoanRepository.save(bean);
    }

    public ThanhtoanDTO getById(Integer id) {
        Thanhtoan original = requireOne(id);
        return toDTO(original);
    }

    public Page<ThanhtoanDTO> query(ThanhtoanQueryVO vO, Pageable pageable ) {
        Page<Thanhtoan> pageResult = thanhtoanRepository.findAll(pageable);
        return pageResult.map(this::toDTO);
    }

    private ThanhtoanDTO toDTO(Thanhtoan original) {
        ThanhtoanDTO bean = new ThanhtoanDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Thanhtoan requireOne(Integer id) {
        return thanhtoanRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
