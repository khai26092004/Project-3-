package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.NguoidungDTO;
import org.hvk.hvk.model.Nguoidung;
import org.hvk.hvk.repository.NguoiDungRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoidungService {

    @Autowired
    private NguoiDungRepository nguoidungRepository;

    public List<Nguoidung> getNguoidungList() {
        return nguoidungRepository.findAll();
    }

    public Boolean save(@Valid NguoidungDTO nguoidungDTO) {
        try {
            Nguoidung nguoidung = new Nguoidung();
            BeanUtils.copyProperties(nguoidungDTO, nguoidung);
            nguoidungRepository.save(nguoidung);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Integer id, NguoidungDTO nguoidungDTO) {
        try {
            Nguoidung nguoidung = findById(id);
            BeanUtils.copyProperties(nguoidungDTO, nguoidung);
            nguoidungRepository.save(nguoidung);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void delete(Integer id) {
        nguoidungRepository.deleteById(id);
    }

    public Nguoidung findById(Integer id) {
        return nguoidungRepository.findById(id).orElseThrow(() -> new RuntimeException("Nguoidung not found"));
    }
}