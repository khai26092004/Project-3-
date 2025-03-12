package org.hvk.hvk.repository;

import org.hvk.hvk.model.Nguoidung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface NguoiDungRepository extends JpaRepository<Nguoidung, Integer>, JpaSpecificationExecutor<Nguoidung> {
    Optional<Nguoidung> findByTendangnhap(String tendangnhap);
}
