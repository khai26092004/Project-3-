package org.hvk.hvk.repository;

import org.hvk.hvk.model.Giangvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GiangvienRepository extends JpaRepository<Giangvien, Integer>, JpaSpecificationExecutor<Giangvien> {

}