package com.nagarro.excercise.service.impl;

import com.nagarro.excercise.service.SentenceAlgorithmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class SentenceAlgorithmServiceImplTest {

    SentenceAlgorithmService sentenceAlgorithmService;

    @BeforeEach
    void setUp() {
        sentenceAlgorithmService = new SentenceAlgorithmServiceImpl();
    }

    @Test
    void replaceWord_Test(){
        String input[] = {"Copyright,Microsoft:Corporation","IT"};
        String expectedResult = "C7t,M6t:C6n I0T";
        String result = sentenceAlgorithmService.replaceWord(input);
        assertNotNull(result);
        assertEquals(result, expectedResult);
    }

    @Test
    void replaceWord_Test_second_case(){
        String input[] = {"It", "was","many", "and", "many", "a","year", "ago"};
        String expectedResult = "I0t w1s m2y a1d m2y a y2r a1o";
        String result = sentenceAlgorithmService.replaceWord(input);
        assertNotNull(result);
        assertEquals(result.trim(), expectedResult.trim());
    }

    @Test
    void orderInputSentence_test(){
        String input[] = {"Copyright,Microsoft:Corporation","IT"};
        List<String> result = sentenceAlgorithmService.orderInputSentence(input);
        assertNotNull(result);
        assertEquals(result.size(), 4);
    }

    @Test
    void orderInputSentence_test_empty(){
        String input[] = {};
        List<String> result = sentenceAlgorithmService.orderInputSentence(input);
        assertNotNull(result);
    }
}