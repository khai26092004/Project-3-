package org.hvk.hvk.repository;


import org.hvk.hvk.model.DangKyHocTrangThai;
import org.hvk.hvk.model.Dangkyhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DangkyhocRepository extends JpaRepository<Dangkyhoc, Integer>, JpaSpecificationExecutor<Dangkyhoc> {
    // Find registrations by student or class
    List<Dangkyhoc> findByMaHocVien(Integer maHocVien);
    List<Dangkyhoc> findByMaLopHoc(Integer maLopHoc);

    // Find registrations by status
    List<Dangkyhoc> findByTrangThai(DangKyHocTrangThai trangThai);
}