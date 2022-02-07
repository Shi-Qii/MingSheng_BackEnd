package com.example.demo.controller;

import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
public class stockDataController {

//    @Autowired
//    institutionalJPA jpa;

    @Autowired
    StockService stockService;
//        先保留原本用jpa 撈資料 ，現在改用 python 返回字串
//    @GetMapping("/api/getStockData")
//    public List<institutional> getStockData() {
//        List<institutional> jpaAll = jpa.query();
//        System.out.println("getAllCourses" + jpaAll);
//        return jpaAll;
//    }



    @PostMapping("/api/getStockData")
    public String getStockData(@RequestBody Map<String,Object> map) throws IOException {
        String data = stockService.getData((Map<String, Object>) map.get("key"));
        return data;
    }


}
