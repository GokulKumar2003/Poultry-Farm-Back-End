package com.PF.PoultryFarm.dao;

import com.PF.PoultryFarm.entity.CompositeKey;
import com.PF.PoultryFarm.entity.ProductionAndDeath;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionAndDeathRepository extends JpaRepository<ProductionAndDeath, CompositeKey> {
    List<ProductionAndDeath> findByDateBetweenOrderByDateAscShedIdAsc(Date startDate, Date endDate);

    List<ProductionAndDeath> findByDateBetweenAndShedIdOrderByDateAscShedIdAsc(Date startDate, Date endDate, int shedId);
}