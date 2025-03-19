package org.hvk.hvk.repository;

import org.hvk.hvk.model.Khoahoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.util.List;

public interface KhoahocRepository extends JpaRepository<Khoahoc, Integer>, JpaSpecificationExecutor<Khoahoc> {
    // Find courses by name (e.g., for search functionality)
    List<Khoahoc> findByTenKhoaHocContainingIgnoreCase(String tenKhoaHoc);

    // Find courses with fees greater than a value
    List<Khoahoc> findByHocPhiGreaterThan(BigDecimal hocPhi);
}