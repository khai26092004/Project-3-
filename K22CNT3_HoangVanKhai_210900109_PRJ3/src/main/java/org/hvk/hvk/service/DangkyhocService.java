package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.DangkyhocDTO;
import org.hvk.hvk.model.Dangkyhoc;
import org.hvk.hvk.repository.DangkyhocRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DangkyhocService {

    @Autowired
    private DangkyhocRepository dangkyhocRepository;

    public List<Dangkyhoc> getDangkyhocList(){
        return dangkyhocRepository.findAll();
    }

    public Boolean save(@Valid @RequestBody DangkyhocDTO dangkyhocDTO) {
        try {
            Dangkyhoc dangkyhoc = new Dangkyhoc();
            dangkyhoc.setMaHocVien(dangkyhocDTO.getMaHocVien());
            dangkyhoc.setMaLopHoc(dangkyhocDTO.getMaLopHoc());
            dangkyhoc.setNgayDangKy(dangkyhocDTO.getNgayDangKy());
            dangkyhoc.setTrangThai(dangkyhocDTO.getTrangThai());
            dangkyhocRepository.save(dangkyhoc);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void delete(Integer id) {
        dangkyhocRepository.deleteById(id);
    }

    public Boolean update(Integer id, DangkyhocDTO dangkyhocDTO) {
        try {
            Dangkyhoc bean = findById(id);
            BeanUtils.copyProperties(dangkyhocDTO, bean);
            dangkyhocRepository.save(bean);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public Dangkyhoc findById(Integer id) {
        return dangkyhocRepository.findById(id).get();
    }

}
