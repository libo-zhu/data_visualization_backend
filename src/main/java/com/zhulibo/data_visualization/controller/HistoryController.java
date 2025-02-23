package com.zhulibo.data_visualization.controller;
import com.zhulibo.data_visualization.entity.History;
import com.zhulibo.data_visualization.entity.HistoryCity;
import com.zhulibo.data_visualization.service.HistoryService;
import com.zhulibo.data_visualization.repository.HistoryCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "http://localhost:8081") // 根据前端地址配置
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistoryCityRepository historyCityRepository;

    @GetMapping("/{url}")
    public List<History> getHistoryByCityUrl(@PathVariable String url) {
        // 根据 url 获取 cityName
        HistoryCity historyCity = historyCityRepository.findByUrl(url).orElse(null);
        if (historyCity == null) {
            throw new RuntimeException("城市不存在");
        }
        return historyService.getHistoryByCity(historyCity.getCityName());
    }
}