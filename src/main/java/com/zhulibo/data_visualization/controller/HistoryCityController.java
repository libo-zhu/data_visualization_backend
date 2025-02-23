package com.zhulibo.data_visualization.controller;
import com.zhulibo.data_visualization.entity.HistoryCity;
import com.zhulibo.data_visualization.service.HistoryCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history_cities")
@CrossOrigin(origins = "http://localhost:8081") // 根据前端地址配置
public class HistoryCityController {

    @Autowired
    private HistoryCityService historyCityService;

    @GetMapping
    public List<HistoryCity> getAllCities() {
        return historyCityService.getAllCities();
    }
}
