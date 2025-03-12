package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.LophocDTO;
import org.hvk.hvk.model.Lophoc;
import org.hvk.hvk.repository.LophocRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LophocService {

    @Autowired
    private LophocRepository lophocRepository;

    public List<Lophoc> getLophocList() {
        return lophocRepository.findAll();
    }

    public Boolean save(@Valid LophocDTO lophocDTO) {
        try {
            Lophoc lophoc = new Lophoc();
            BeanUtils.copyProperties(lophocDTO, lophoc);
            lophocRepository.save(lophoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Integer id, LophocDTO lophocDTO) {
        try {
            Lophoc lophoc = findById(id);
            BeanUtils.copyProperties(lophocDTO, lophoc);
            lophocRepository.save(lophoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(Integer id) {
        lophocRepository.deleteById(id);
    }

    public Lophoc findById(Integer id) {
        return lophocRepository.findById(id).orElseThrow(() -> new RuntimeException("Lophoc not found"));
    }
}