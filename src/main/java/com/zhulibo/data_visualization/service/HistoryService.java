package com.zhulibo.data_visualization.service;

import com.zhulibo.data_visualization.entity.History;
import com.zhulibo.data_visualization.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getHistoryByCity(String city) {
        return historyRepository.findByCityOrderByDateAsc(city);
    }
}
