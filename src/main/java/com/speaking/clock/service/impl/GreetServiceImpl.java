package com.speaking.clock.service.impl;

import com.speaking.clock.exception.InvalidInputException;
import com.speaking.clock.model.GreetMessageModel;
import com.speaking.clock.model.TimeConverterInputModel;
import com.speaking.clock.service.GreetService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class GreetServiceImpl implements GreetService {

    static final LocalTime morning = LocalTime.of(0, 0, 0);
    static final LocalTime midday = LocalTime.of(12, 0, 0);
    static final LocalTime evening = LocalTime.of(16, 0, 0);
    static final LocalTime midnight = LocalTime.of(21, 0, 0);

    @Override
    public GreetMessageModel getGreetMessage(TimeConverterInputModel timeConverterInputModel) {
        if (timeConverterInputModel.getTime() == null || timeConverterInputModel.getTime().isEmpty()) {
            throw new InvalidInputException("Empty Input");
        }

        if (!timeConverterInputModel.getTime().contains(":")) {
            throw new InvalidInputException("Input should be in hh:mm format");
        }

        String result=deterMineGreeting(timeConverterInputModel.getTime());

        return new GreetMessageModel(result);
    }

    private String deterMineGreeting(String time) {
        String[] timeArray = time.split(":");

        String greet = "";

        LocalTime currentTime = LocalTime.of(Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));

        if (!currentTime.isBefore(morning) && currentTime.isBefore(midday)) {
            greet = "its morning";
        } else if (!currentTime.isBefore(midday) && currentTime.isBefore(evening)) {
            greet = "its midday";
        } else if (!currentTime.isBefore(evening) && currentTime.isBefore(midnight)) {
            greet = "its evening";
        } else {
            greet = "its midnight";
        }

        return greet;
    }
}
