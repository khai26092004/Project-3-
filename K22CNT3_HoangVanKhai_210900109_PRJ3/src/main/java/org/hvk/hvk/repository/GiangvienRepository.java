package org.hvk.hvk.repository;

import org.hvk.hvk.model.Giangvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface GiangvienRepository extends JpaRepository<Giangvien, Integer>, JpaSpecificationExecutor<Giangvien> {
    // Find instructors by expertise or email
    List<Giangvien> findByChuyenMon(String chuyenMon);
    Optional<Giangvien> findByEmail(String email);
}