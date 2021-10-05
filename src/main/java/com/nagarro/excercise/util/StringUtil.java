package com.nagarro.excercise.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtil {

	private static final String BLANK_SPACE = " ";

	/*Get separators from a input String and storing them in a queue for a FIFO behavior
	 * */
	public static Queue<String> getSeparators(String[] input) {
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
	
	/*Get the number of distinct Characters from a given string
	 * */
	public static Integer getNumberOfDistinctCharacters(String input) {		
		Set<Character> charsSet = input.chars()
			    .mapToObj(e->(char)e).collect(Collectors.toSet());

		return charsSet.size();
	}
	
	/*Get the First Character from a given String
	 * */
	public static String getFirstCharacter(String input) {
        char[] charArray = input.toCharArray();
        return String.valueOf(charArray[0]);
	}
	
	
	/*Get the last Character from a given String
	 * */
	public static String getLastCharacter(String input) {
       char[] charArray = input.toCharArray();
       int n = charArray.length;  
       return String.valueOf(charArray[n - 1]);
	}
}
