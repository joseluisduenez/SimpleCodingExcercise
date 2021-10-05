package com.nagarro.excercise.util;
import com.nagarro.excercise.exceptions.ValidationException;

public class ValidationUtil {

	private static final  String INPUT_EMPTY = "Please enter a sentence to validate";	

	public static Boolean validateInput(String[] args) throws ValidationException {
		if(args.length == 0)
			throw new ValidationException(INPUT_EMPTY);
		return true;
	}
}
