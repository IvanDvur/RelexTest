package com.example.relextest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


//Сервис возвращает все результаты в единый FileResponseDto
@Service
public class SingleFileService {

    private final RelexService relexService;

    public SingleFileService(RelexService relexService) {
        this.relexService = relexService;
    }

    public String multipartFileToFile(MultipartFile file) throws IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile.getAbsolutePath();
    }

    public ArrayList<String> getValues(String path){
        ArrayList<String> results = new ArrayList<>();
        String maxValue = relexService.getMaxValue(path);
        String minValue = relexService.getMinValue(path);
        String averageValue = relexService.getAverage(path);
        String medianeValue = relexService.getMediane(path);
        String ascSeq = relexService.getAscendingSequences(path);
        String descSq = relexService.getDescendingSequences(path);
        Collections.addAll(results,maxValue,minValue,averageValue,medianeValue,ascSeq,descSq);
        return results;
    }


}
