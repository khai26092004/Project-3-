package org.hvk.hvk.repository;

import org.hvk.hvk.model.Thanhtoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ThanhtoanRepository extends JpaRepository<Thanhtoan, Integer>, JpaSpecificationExecutor<Thanhtoan> {

}