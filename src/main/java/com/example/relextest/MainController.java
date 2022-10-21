package com.example.relextest;

import com.example.relextest.model.RequestDto;
import com.example.relextest.model.ResponseDto;
import com.example.relextest.service.RelexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    RelexServiceImpl relexService;

    @Autowired
    public MainController(RelexServiceImpl relexService) {
        this.relexService = relexService;
    }

    @GetMapping("/max")
    public ResponseDto getMaxValue(@RequestParam(name = "jsonUrl", required = false) String jsonUrl) {
        return new ResponseDto(relexService.getMaxValue(jsonUrl));
    }

    @GetMapping("/min")
    public ResponseDto getMinValue(@RequestBody RequestDto requestDto) {
        return new ResponseDto(this.relexService.getMinValue(requestDto.getPath()));
    }

    @GetMapping("/average")
    public ResponseDto getAverage(@RequestBody RequestDto requestDto) {
        return new ResponseDto(relexService.getAverage(requestDto.getPath()));
    }

    @GetMapping("/mediane")
    public ResponseDto getMediane(@RequestBody RequestDto requestDto) {
        return new ResponseDto(relexService.getMediane(requestDto.getPath()));
    }

    @GetMapping("/getAscend")
    public ResponseDto getAscendingSeq(@RequestParam(name = "jsonUrl", required = false) String jsonUrl) {
        return null;
    }

    @GetMapping("/getDescend")
    public ResponseDto getDescendingSeq(@RequestParam(name = "jsonUrl", required = false) String jsonUrl) {
        return null;
    }
}

