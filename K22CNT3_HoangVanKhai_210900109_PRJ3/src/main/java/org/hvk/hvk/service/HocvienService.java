package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.HocvienDTO;
import org.hvk.hvk.model.Hocvien;
import org.hvk.hvk.repository.HocvienRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocvienService {

    @Autowired
    private HocvienRepository hocvienRepository;

    public List<Hocvien> getHocvienList() {
        return hocvienRepository.findAll();
    }

    public Boolean save(@Valid HocvienDTO hocvienDTO) {
        try {
            Hocvien hocvien = new Hocvien();
            BeanUtils.copyProperties(hocvienDTO, hocvien);
            hocvienRepository.save(hocvien);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Integer id, HocvienDTO hocvienDTO) {
        try {
            Hocvien hocvien = findById(id);
            BeanUtils.copyProperties(hocvienDTO, hocvien, "ngayTao"); // Preserve original creation date
            hocvienRepository.save(hocvien);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(Integer id) {
        hocvienRepository.deleteById(id);
    }

    public Hocvien findById(Integer id) {
        return hocvienRepository.findById(id).orElseThrow(() -> new RuntimeException("Hocvien not found"));
    }
}