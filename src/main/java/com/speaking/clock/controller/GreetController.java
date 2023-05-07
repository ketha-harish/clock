package com.speaking.clock.controller;

import com.speaking.clock.model.CommonResponseModel;
import com.speaking.clock.model.GreetMessageModel;
import com.speaking.clock.model.TimeConverterInputModel;
import com.speaking.clock.service.GreetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet")
public class GreetController {

    private final GreetService greetService;


    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }

    @PostMapping("/message-by-time")
    ResponseEntity<CommonResponseModel> getGreetMessage(@PathVariable @RequestBody TimeConverterInputModel timeConverterInputModel){
        GreetMessageModel greetMessageModel=greetService.getGreetMessage(timeConverterInputModel);
        return new ResponseEntity<CommonResponseModel>(new CommonResponseModel("0","",greetMessageModel), HttpStatus.OK);
    }

    @GetMapping("/message")
    ResponseEntity respondSampleMessage(){
        return new ResponseEntity("Sample Message",HttpStatus.OK);
    }
}
