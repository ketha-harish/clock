package com.speaking.clock.service;

import com.speaking.clock.exception.InvalidInputException;
import com.speaking.clock.model.TimeConverterInputModel;
import com.speaking.clock.model.TimeConverterResponseModel;
import com.speaking.clock.service.impl.TimeConvertServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TimeConverterServiceTest {


    private TimeConvertServiceImpl timeConvertService;

    @Before
    public void setUp() {
        timeConvertService = new TimeConvertServiceImpl();
    }

    @Test
    public void validInputTest() {
        TimeConverterResponseModel timeConverterResponseModel = timeConvertService.convertTimeToWords(new TimeConverterInputModel("12:36"));

        assertNotNull(timeConverterResponseModel);
    }

    @Test(expected = InvalidInputException.class)
    public void invalidEmptyInputTest() {
        timeConvertService.convertTimeToWords(new TimeConverterInputModel(""));
    }

    @Test(expected = InvalidInputException.class)
    public void invalidInputTest() {
        timeConvertService.convertTimeToWords(new TimeConverterInputModel("wrongvalue"));
    }
}
