package com.example.relextest;

import com.example.relextest.service.RelexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class MainController {

    RelexServiceImpl relexService;

    @Autowired
    public MainController(RelexServiceImpl relexService) {
        this.relexService = relexService;
    }

    @GetMapping("/max")
    public Integer getMaxValue(@RequestParam(name = "jsonUrl", required = false) String jsonUrl) {
        return relexService.getMaxValue(jsonUrl);
    }

    @GetMapping("/min")
    public Integer getMinValue(@RequestParam(name = "jsonUrl", required = false) String jsonUrl) {
        return relexService.getMinValue(jsonUrl);
    }

    @GetMapping("/average")
    public Double getAverage(@RequestParam(name = "jsonUrl", required = false) String jsonUrl) {
        return relexService.getAverage(jsonUrl);
    }

    @GetMapping("/mediane")
    public Double getMediane(@RequestParam(name = "jsonUrl",required = false) String jsonUrl){
        return relexService.getMediane(jsonUrl);
    }

    @GetMapping("/getAscend")
    public List<Integer> getAscendingSeq(@RequestParam(name = "jsonUrl",required = false) String jsonUrl){
        return relexService.getAscendingSequences(jsonUrl);
    }
    @GetMapping("/getDescend")
    public List<Integer> getDescendingSeq(@RequestParam(name = "jsonUrl",required = false) String jsonUrl){
        return relexService.getDescendingSequences(jsonUrl);
    }
}
