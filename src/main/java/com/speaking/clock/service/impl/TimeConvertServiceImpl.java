package com.speaking.clock.service.impl;

import com.speaking.clock.exception.InvalidInputException;
import com.speaking.clock.model.TimeConverterInputModel;
import com.speaking.clock.model.TimeConverterResponseModel;
import com.speaking.clock.service.TimeConvertService;
import org.springframework.stereotype.Service;

@Service
public class TimeConvertServiceImpl implements TimeConvertService {
    @Override
    public TimeConverterResponseModel convertTimeToWords(TimeConverterInputModel timeConverterInputModel) {

        if (timeConverterInputModel.getTime() == null || timeConverterInputModel.getTime().isEmpty()) {
            throw new InvalidInputException("Empty Input");
        }

        if (!timeConverterInputModel.getTime().contains(":")) {
            throw new InvalidInputException("Input should be in hh:mm format");
        }

        String[] timeArray = timeConverterInputModel.getTime().split(":");

        String result = convertNumberToWord(Integer.parseInt(timeArray[0])) + " " + convertNumberToWord(Integer.parseInt(timeArray[1]));

        return new TimeConverterResponseModel("its "+result);
    }

    private String convertNumberToWord(int inputNumber) {


        String[] singleDigitWords = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

        String[] teenDigitWords = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] digitDigitWords = {"", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};

        String word = "";

        if (inputNumber <= 10) {
            word = singleDigitWords[inputNumber - 1];
        } else if (inputNumber <= 19) {
            word = teenDigitWords[(inputNumber % 10) - 1];
        } else {
            int remainder = inputNumber % 10;
            int quotient = inputNumber / 10;

            if (remainder == 0) {
                word = digitDigitWords[quotient - 1];
            } else {
                word = digitDigitWords[quotient - 1] + " " + singleDigitWords[remainder - 1];
            }
        }

        return word.toLowerCase();
    }

}
