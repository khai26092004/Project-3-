package org.hvk.hvk.repository;

import org.hvk.hvk.model.Hocvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HocvienRepository extends JpaRepository<Hocvien, Integer>, JpaSpecificationExecutor<Hocvien> {
    // Find students by email or phone (e.g., for uniqueness checks or searches)
    Optional<Hocvien> findByEmail(String email);
    Optional<Hocvien> findBySoDienThoai(String soDienThoai);

    // Find students created after a specific date
    List<Hocvien> findByNgayTaoAfter(LocalDate date);
}