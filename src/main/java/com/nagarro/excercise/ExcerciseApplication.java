package com.nagarro.excercise;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.nagarro.excercise.exceptions.ValidationException;
import com.nagarro.excercise.service.SentenceAlgorithmService;
import com.nagarro.excercise.service.impl.SentenceAlgorithmServiceImpl;
import com.nagarro.excercise.util.ValidationUtil;

/*
 *Write a program that parses a sentence and replaces each word with the following: first letter, number of distinct characters between first and last character, and last letter. 
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer
 * */
public class ExcerciseApplication {
	
	private static final Logger log = Logger.getLogger(ExcerciseApplication.class);

	public static void main(String[] args)  {
		BasicConfigurator.configure();

		try {
			ValidationUtil.validateInput(args);
			SentenceAlgorithmService sentenceService = new SentenceAlgorithmServiceImpl();
			final String response = sentenceService.replaceWord(args);
			log.info(response);
		} catch (ValidationException e) {
			log.error(e.getMessage());
		} 
	}
}
