package com.nagarro.excercise.util;

import com.nagarro.excercise.exceptions.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    @Test()
    void validateInput_empty(){
        String input[] = {};
        Assertions.assertThrows(ValidationException.class, () -> {
            ValidationUtil.validateInput(input);
        });
    }

    @Test()
    void validateInput() throws ValidationException {
        String input[] = {"data"};
        assertEquals(true,ValidationUtil.validateInput(input));

    }
}