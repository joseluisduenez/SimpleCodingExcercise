package com.nagarro.excercise.util;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void getSeparators() {
        String input[] = {"Copyright,Microsoft:Corporation","IT"};
        Queue<String> result = StringUtil.getSeparators(input);
        assertNotNull(result);
        assertEquals(3,result.size());
    }

    @Test
    void getNumberOfDistinctCharacters() {
        String input = "abcd";
        Integer result = StringUtil.getNumberOfDistinctCharacters(input);
        assertNotNull(result);
        assertEquals(4,result);
    }

    @Test
    void getFirstCharacter() {
        String input = "abcd";
        String result = StringUtil.getFirstCharacter(input);
        assertNotNull(result);
        assertEquals("a",result);
    }

    @Test
    void getLastCharacter() {
        String input = "abcd";
        String result = StringUtil.getLastCharacter(input);
        assertNotNull(result);
        assertEquals("d",result);
    }
}