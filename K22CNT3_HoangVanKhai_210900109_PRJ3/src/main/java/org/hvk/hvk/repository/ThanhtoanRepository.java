package org.hvk.hvk.repository;

import org.hvk.hvk.model.Thanhtoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ThanhtoanRepository extends JpaRepository<Thanhtoan, Integer>, JpaSpecificationExecutor<Thanhtoan> {
    // Find payments by student or course
    List<Thanhtoan> findByMaHocVien(Integer maHocVien);
    List<Thanhtoan> findByMaKhoaHoc(Integer maKhoaHoc);

    // Find recent payments (e.g., for dashboard)
    List<Thanhtoan> findTop5ByOrderByNgayThanhToanDesc();

    // Find payments by status
    List<Thanhtoan> findByTrangThai(String trangThai);
}