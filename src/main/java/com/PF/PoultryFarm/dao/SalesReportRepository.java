package com.PF.PoultryFarm.dao;

import com.PF.PoultryFarm.entity.CompositeKey;
import com.PF.PoultryFarm.entity.Sales;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReportRepository extends JpaRepository<Sales, CompositeKey> {
    List<Sales> findByDateBetweenOrderByDateAscShedIdAsc(Date startDate, Date endDate);

    List<Sales> findByDateBetweenAndShedIdOrderByDateAscShedIdAsc(Date startDate, Date endDate, int shedId);
}
