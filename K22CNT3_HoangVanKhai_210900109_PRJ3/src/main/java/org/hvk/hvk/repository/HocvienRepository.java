package org.hvk.hvk.repository;

import org.hvk.hvk.model.Hocvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HocvienRepository extends JpaRepository<Hocvien, Integer>, JpaSpecificationExecutor<Hocvien> {

}