package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.NguoidungDTO;
import org.hvk.hvk.model.Nguoidung;
import org.hvk.hvk.repository.NguoiDungRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoidungService {

    @Autowired
    private NguoiDungRepository nguoidungRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject BCryptPasswordEncoder

    public List<Nguoidung> getNguoidungList() {
        return nguoidungRepository.findAll();
    }

    public Boolean save(@Valid NguoidungDTO nguoidungDTO) {
        try {
            Nguoidung nguoidung = new Nguoidung();
            BeanUtils.copyProperties(nguoidungDTO, nguoidung);
            // Encrypt the password before saving
            nguoidung.setMatkhau(passwordEncoder.encode(nguoidungDTO.getMatkhau()));
            nguoidungRepository.save(nguoidung);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Integer id, NguoidungDTO nguoidungDTO) {
        try {
            Nguoidung nguoidung = findById(id);
            // Only encode the password if it’s provided and different from the current one
            if (nguoidungDTO.getMatkhau() != null && !nguoidungDTO.getMatkhau().isEmpty()) {
                if (!passwordEncoder.matches(nguoidungDTO.getMatkhau(), nguoidung.getMatkhau())) {
                    nguoidung.setMatkhau(passwordEncoder.encode(nguoidungDTO.getMatkhau()));
                }
            }
            BeanUtils.copyProperties(nguoidungDTO, nguoidung, "matkhau"); // Exclude matkhau from copy to avoid overwriting
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