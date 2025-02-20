package com.PF.PoultryFarm.dao;

import com.PF.PoultryFarm.entity.ShedStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShedStockRepository extends JpaRepository<ShedStock, Integer> {
}