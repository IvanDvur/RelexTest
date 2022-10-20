package com.example.relextest;

import com.example.relextest.service.RelexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MainController {

    RelexServiceImpl relexService;

    @Autowired
    public MainController(RelexServiceImpl relexService) {
        this.relexService = relexService;
    }

    @GetMapping("/max")
    public Integer getMaxValue(@RequestParam(name = "jsonUrl", required = true) String jsonUrl) {
        return relexService.getMaxValue(jsonUrl);
    }
    @GetMapping("/min")
    public Integer getMinValue(@RequestParam(name = "jsonUrl", required = true) String jsonUrl) {
        return relexService.getMinValue(jsonUrl);
    }
}
