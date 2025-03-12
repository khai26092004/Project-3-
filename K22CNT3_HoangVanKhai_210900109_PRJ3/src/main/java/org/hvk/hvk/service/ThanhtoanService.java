package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.ThanhtoanDTO;
import org.hvk.hvk.model.Thanhtoan;
import org.hvk.hvk.repository.ThanhtoanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThanhtoanService {

    @Autowired
    private ThanhtoanRepository thanhtoanRepository;

    public List<Thanhtoan> getThanhtoanList() {
        return thanhtoanRepository.findAll();
    }

    public Boolean save(@Valid ThanhtoanDTO thanhtoanDTO) {
        try {
            Thanhtoan thanhtoan = new Thanhtoan();
            BeanUtils.copyProperties(thanhtoanDTO, thanhtoan);
            thanhtoanRepository.save(thanhtoan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Integer id, ThanhtoanDTO thanhtoanDTO) {
        try {
            Thanhtoan thanhtoan = findById(id);
            BeanUtils.copyProperties(thanhtoanDTO, thanhtoan);
            thanhtoanRepository.save(thanhtoan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(Integer id) {
        thanhtoanRepository.deleteById(id);
    }

    public Thanhtoan findById(Integer id) {
        return thanhtoanRepository.findById(id).orElseThrow(() -> new RuntimeException("Thanhtoan not found"));
    }
}