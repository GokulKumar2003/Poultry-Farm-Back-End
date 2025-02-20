package com.PF.PoultryFarm.dao;

import com.PF.PoultryFarm.entity.ShedProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShedProductionRepository extends JpaRepository<ShedProduction, Integer> {
}