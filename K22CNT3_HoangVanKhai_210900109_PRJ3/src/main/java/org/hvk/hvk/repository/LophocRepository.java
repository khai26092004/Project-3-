package org.hvk.hvk.repository;

import org.hvk.hvk.model.Lophoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface LophocRepository extends JpaRepository<Lophoc, Integer>, JpaSpecificationExecutor<Lophoc> {
    // Find classes by course or instructor
    List<Lophoc> findByMaKhoaHoc(Integer maKhoaHoc);
    List<Lophoc> findByMaGiangVien(Integer maGiangVien);

    // Find active classes (between start and end dates)
    List<Lophoc> findByNgayBatDauLessThanEqualAndNgayKetThucGreaterThanEqual(LocalDate start, LocalDate end);
}