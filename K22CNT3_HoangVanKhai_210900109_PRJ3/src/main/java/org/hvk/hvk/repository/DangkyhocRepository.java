package org.hvk.hvk.repository;


import org.hvk.hvk.model.Dangkyhoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DangkyhocRepository extends JpaRepository<Dangkyhoc, Integer>, JpaSpecificationExecutor<Dangkyhoc>{
}