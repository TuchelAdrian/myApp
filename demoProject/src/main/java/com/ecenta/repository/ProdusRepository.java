package com.ecenta.repository;

import com.ecenta.entity.ProdusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdusRepository extends JpaRepository<ProdusEntity, Integer> {
}
