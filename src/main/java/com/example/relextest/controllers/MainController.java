package com.example.relextest.controllers;

import com.example.relextest.model.FullResponceDto;
import com.example.relextest.model.RequestDto;
import com.example.relextest.model.ResponseDto;
import com.example.relextest.service.RelexService;
import com.example.relextest.service.SingleFileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    private final RelexService relexService;
    private final SingleFileService singleFileService;

    public MainController(RelexService relexService, SingleFileService singleFileService) {
        this.relexService = relexService;
        this.singleFileService = singleFileService;
    }

    // Получение результатов по отдельности в JSON или XML формате
    @GetMapping(value = {"/makeoperation", "/makeoperation/{operation}"},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseDto makeoperation(@RequestBody RequestDto requestDto,
                                     @PathVariable(name = "operation", required = false) String operation) {
//        Если операция указана в JSON
        if (operation == null && requestDto.getOperation() != null) {
//            Максимальное значение
            if (requestDto.getOperation().equals("get_max"))
                return new ResponseDto(relexService.getMaxValue(requestDto.getPath()));
//            Минимальное значение
            if (requestDto.getOperation().equals("get_min"))
                return new ResponseDto(relexService.getMinValue(requestDto.getPath()));
//            Среднее арифметическое
            if (requestDto.getOperation().equals("get_average"))
                return new ResponseDto(relexService.getAverage(requestDto.getPath()));
//            Медиана
            if (requestDto.getOperation().equals("get_mediane"))
                return new ResponseDto(relexService.getMediane(requestDto.getPath()));
//            Возрастающие последовательности
            if (requestDto.getOperation().equals("get_ascend"))
                return new ResponseDto(relexService.getAscendingSequences(requestDto.getPath()));
//            Убывающие последовательности
            if (requestDto.getOperation().equals("get_descend"))
                return new ResponseDto(relexService.getDescendingSequences(requestDto.getPath()));
        }
//        Если операция указана в URL
        if (operation != null && requestDto.getOperation() == null) {
            if (operation.equals("get_max"))
                return new ResponseDto(relexService.getMaxValue(requestDto.getPath()));
            if (operation.equals("get_min"))
                return new ResponseDto(relexService.getMinValue(requestDto.getPath()));
            if (operation.equals("get_average"))
                return new ResponseDto(relexService.getAverage(requestDto.getPath()));
            if (operation.equals("get_mediane"))
                return new ResponseDto(relexService.getMediane(requestDto.getPath()));
            if (operation.equals("get_ascend"))
                return new ResponseDto(relexService.getAscendingSequences(requestDto.getPath()));
            if (operation.equals("get_descend"))
                return new ResponseDto(relexService.getDescendingSequences(requestDto.getPath()));
        }
        return new ResponseDto("Error: file not found or conflict of requests");
    }

    // Передача файла и получение результатов единым ответом
    @PostMapping("/upload")
    public FullResponceDto uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return new FullResponceDto(singleFileService.getValues(singleFileService.multipartFileToFile(file)));
    }

}

