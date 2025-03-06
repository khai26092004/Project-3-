package org.hvk.hvk.repository;

import org.hvk.hvk.model.Lophoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LophocRepository extends JpaRepository<Lophoc, Integer>, JpaSpecificationExecutor<Lophoc> {

}