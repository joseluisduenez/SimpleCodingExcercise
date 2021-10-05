package com.nagarro.excercise.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import com.nagarro.excercise.service.SentenceAlgorithmService;

public class SentenceAlgorithmServiceImpl implements  SentenceAlgorithmService{

	private static final String BLANK_SPACE = " ";
	
	/*Entry point for algorithm, returns all words in a sentence
	 * */
	@Override
	public String replaceWord(String[] input) {
		Queue<String> separators = getSeparators(input);
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
			result = getFirstCharacter(input).concat(getDistinctCharacters(input).toString()).concat(getLastCharacter(input));
		else
			result = input;

		return result;
	}
	
	/*Get the number of distinct Characters from a given string
	 * */
	private Integer getDistinctCharacters(String input) {
		input = input.substring(1, input.length() - 1);
		
		Set<Character> charsSet = input.chars()
			    .mapToObj(e->(char)e).collect(Collectors.toSet());

		return charsSet.size();
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
	
	/*Get separators from input String and storing them in a queue for a FIFO behavior
	 * */
	private Queue<String> getSeparators(String[] input) {
		Queue<String> separators = new LinkedList<>();

		for(int x=0; x<input.length; x++) {
			String innerResult = input[x].replaceAll("[a-zA-Z0-9]", "");
			if(!innerResult.equals("")) {
				char[]  listChars = innerResult.toCharArray();
				for(int y= 0; y<listChars.length; y++) {
					separators.offer(String.valueOf(listChars[y]));
				}	
			}
			else
				separators.offer(BLANK_SPACE);
		}
		
		return separators;
	}
	
	/*Get the First Character from a given String
	 * */
	private String getFirstCharacter(String input) {
        char[] charArray = input.toCharArray();
        return String.valueOf(charArray[0]);
	}
	
	/*Get the last Character from a given String
	 * */
	private String getLastCharacter(String input) {
       char[] charArray = input.toCharArray();
       int n = charArray.length;  
       return String.valueOf(charArray[n - 1]);
	}

}
