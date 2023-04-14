package com.speaking.clock.service;

import com.speaking.clock.model.GreetMessageModel;
import com.speaking.clock.model.TimeConverterInputModel;

public interface GreetService {
    GreetMessageModel getGreetMessage(TimeConverterInputModel timeConverterInputModel);
}
