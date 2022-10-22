package com.example.relextest;

import com.example.relextest.model.RequestDto;
import com.example.relextest.model.ResponseDto;
import com.example.relextest.service.RelexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MainController {

    RelexServiceImpl relexService;

    @Autowired
    public MainController(RelexServiceImpl relexService) {
        this.relexService = relexService;
    }

    @GetMapping(value = {"/makeoperation", "/makeoperation/{operation}"},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseDto makeoperation(@RequestBody RequestDto requestDto,
                                     @PathVariable(name = "operation", required = false) String operation) {
//        Если операция указана в JSON
        if (operation == null && requestDto.getOperation() != null) {
            if (requestDto.getOperation().equals("get_max"))
                return new ResponseDto(relexService.getMaxValue(requestDto.getPath()));
            if (requestDto.getOperation().equals("get_min"))
                return new ResponseDto(relexService.getMinValue(requestDto.getPath()));
            if (requestDto.getOperation().equals("get_average"))
                return new ResponseDto(relexService.getAverage(requestDto.getPath()));
            if (requestDto.getOperation().equals("get_mediane"))
                return new ResponseDto(relexService.getMediane(requestDto.getPath()));
            if (requestDto.getOperation().equals("get_ascend"))
                return new ResponseDto(relexService.getAscendingSequences(requestDto.getPath()));
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
        return null;
    }


//    @PostMapping(path = "/file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseDto uploadfile(@RequestParam("file")MultipartFile file){
//        try(InputStream is = file.getInputStream()){
//            return new ResponseDto(relexService.getMinValue(is.))
//        }catch (IOException e){
//            return new ResponseDto("Ошибка");
//        }
//        return null;
//    }
}

