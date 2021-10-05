package com.nagarro.excercise.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import com.nagarro.excercise.service.SentenceAlgorithmService;
import com.nagarro.excercise.util.StringUtil;

public class SentenceAlgorithmServiceImpl implements  SentenceAlgorithmService{
	
	/*Entry point for algorithm, returns all words in a sentence
	 * */
	@Override
	public String replaceWord(String[] input) {
		Queue<String> separators = StringUtil.getSeparators(input);
		List<String> inputOrdered = orderInputSentence(input);
		StringBuilder result = new StringBuilder();
		
		inputOrdered.stream().forEach((word)-> { 
			 result.append(buildWord(word.trim()));
			 result.append(separators.peek()!=null?separators.poll():""); });
		 
		return result.toString();
	}

	/*Build word with first, last and number of distinct characters
	 * */
	private String buildWord(String input) {
		Integer wordSize = input.length();
		String result;
		if(wordSize>1)
			result = StringUtil.getFirstCharacter(input).concat(getDistinctCharacters(input).toString()).concat(StringUtil.getLastCharacter(input));
		else
			result = input;

		return result;
	}
	
	/*Get the number of distinct Characters from a given string
	 * */
	private Integer getDistinctCharacters(String input) {
		input = input.substring(1, input.length() - 1);
		return StringUtil.getNumberOfDistinctCharacters(input);
	}
	
	/*Store each word as a list element
	 * */
	@Override
	public List<String> orderInputSentence(String[] args) {
		String regex = "[~!@#$%^&*()_+{}\\\\[\\\\]:;,.<>/?-]";
		String[] innerResult;
		List<String> result = new ArrayList<String>();
		
		for(int x=0; x<args.length; x++) {
			innerResult = args[x].split(regex);
			result.addAll(Arrays.asList(innerResult));
		}

		return result;
	}
}
