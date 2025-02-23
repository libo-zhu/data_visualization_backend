package com.zhulibo.data_visualization.repository;
import com.zhulibo.data_visualization.entity.HistoryCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoryCityRepository extends JpaRepository<HistoryCity, String> {
    Optional<HistoryCity> findByUrl(String url);
}
