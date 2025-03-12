package org.hvk.hvk.service;

import jakarta.validation.Valid;
import org.hvk.hvk.dto.GiangvienDTO;

import org.hvk.hvk.model.Giangvien;

import org.hvk.hvk.repository.GiangvienRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GiangvienService {

    @Autowired
    private GiangvienRepository giangvienRepository;

    public Boolean save(@Valid @RequestBody GiangvienDTO dangkyhocDTO) {
        try {
            Giangvien bean = new Giangvien();
            BeanUtils.copyProperties(dangkyhocDTO, bean);
            bean = giangvienRepository.save(bean);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Giangvien> getGiangVienList(){
        return giangvienRepository.findAll();
    }

    public void delete(Integer id) {
        giangvienRepository.deleteById(id);
    }

    public Boolean update(Integer id, GiangvienDTO dangkyhocDTO) {
        try {
            Giangvien bean = findById(id);
            BeanUtils.copyProperties(dangkyhocDTO, bean);
            giangvienRepository.save(bean);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public Giangvien findById(Integer id) {
        return giangvienRepository.findById(id).get();
    }
}
