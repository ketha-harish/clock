package com.speaking.clock.service;

import com.speaking.clock.exception.InvalidInputException;
import com.speaking.clock.model.GreetMessageModel;
import com.speaking.clock.model.TimeConverterInputModel;
import com.speaking.clock.service.impl.GreetServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GreetServiceTest {

    private GreetServiceImpl greetService;

    @Before
    public void setUp() {
        greetService = new GreetServiceImpl();
    }

    @Test
    public void validInputTest() {
        GreetMessageModel greetMessageModel=greetService.getGreetMessage(new TimeConverterInputModel("12:36"));

        assertNotNull(greetMessageModel);
    }

    @Test(expected = InvalidInputException.class)
    public void invalidEmptyInputTest() {
        GreetMessageModel greetMessageModel=greetService.getGreetMessage(new TimeConverterInputModel(""));
    }

    @Test(expected = InvalidInputException.class)
    public void invalidInputTest() {
        GreetMessageModel greetMessageModel=greetService.getGreetMessage(new TimeConverterInputModel("wrongvalue"));
    }
}
