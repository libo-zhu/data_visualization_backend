package com.zhulibo.data_visualization.repository;

import com.zhulibo.data_visualization.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
    List<History> findByCityOrderByDateAsc(String city);
}
