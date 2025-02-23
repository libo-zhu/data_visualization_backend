package com.zhulibo.data_visualization.service;
import com.zhulibo.data_visualization.repository.HistoryCityRepository;
import com.zhulibo.data_visualization.entity.HistoryCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryCityService {

    @Autowired
    private HistoryCityRepository historyCityRepository;

    public List<HistoryCity> getAllCities() {
        return historyCityRepository.findAll();
    }
}
