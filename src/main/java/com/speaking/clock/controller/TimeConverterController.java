package com.speaking.clock.controller;

import com.speaking.clock.model.CommonResponseModel;
import com.speaking.clock.model.TimeConverterInputModel;
import com.speaking.clock.model.TimeConverterResponseModel;
import com.speaking.clock.service.TimeConvertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convert")
public class TimeConverterController {

    private final TimeConvertService timeConvertService;


    public TimeConverterController(TimeConvertService timeConvertService) {
        this.timeConvertService = timeConvertService;
    }

    @PostMapping("/speak-time")
    ResponseEntity<CommonResponseModel> convertTimeToWords(@RequestBody TimeConverterInputModel timeConverterInputModel) {
        TimeConverterResponseModel timeConverterResponseModel= timeConvertService.convertTimeToWords(timeConverterInputModel);
        return new ResponseEntity<>(new CommonResponseModel("0","success",timeConverterResponseModel), HttpStatus.OK);
    }

}
