package org.hvk.hvk.repository;

import org.hvk.hvk.model.Khoahoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface KhoahocRepository extends JpaRepository<Khoahoc, Integer>, JpaSpecificationExecutor<Khoahoc> {

}