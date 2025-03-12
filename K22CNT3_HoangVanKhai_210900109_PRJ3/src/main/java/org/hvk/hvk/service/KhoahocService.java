package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.KhoahocDTO;
import org.hvk.hvk.model.Khoahoc;
import org.hvk.hvk.repository.KhoahocRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class KhoahocService {

    @Autowired
    private KhoahocRepository khoahocRepository;

    public List<Khoahoc> getKhoahocList() {
        return khoahocRepository.findAll();
    }

    public Boolean save(@Valid KhoahocDTO khoahocDTO) {
        try {
            Khoahoc khoahoc = new Khoahoc();
            BeanUtils.copyProperties(khoahocDTO, khoahoc);
            khoahoc.setNgayTao(LocalDate.now()); // Set creation date
            khoahocRepository.save(khoahoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Integer id, KhoahocDTO khoahocDTO) {
        try {
            Khoahoc khoahoc = findById(id);
            BeanUtils.copyProperties(khoahocDTO, khoahoc, "ngayTao"); // Preserve original creation date
            khoahocRepository.save(khoahoc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(Integer id) {
        khoahocRepository.deleteById(id);
    }

    public Khoahoc findById(Integer id) {
        return khoahocRepository.findById(id).orElseThrow(() -> new RuntimeException("Khoahoc not found"));
    }
}