package com.speaking.clock.service;

import com.speaking.clock.model.TimeConverterInputModel;
import com.speaking.clock.model.TimeConverterResponseModel;

public interface TimeConvertService {
    TimeConverterResponseModel convertTimeToWords(TimeConverterInputModel timeConverterInputModel);
}
