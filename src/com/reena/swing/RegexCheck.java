package com.reena.swing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheck {
	
	public static String stringMatcher(String input, String regex) {
		return input.matches(regex) ? "Found!!" :"Not found!!";		
	}
	
	public static String patternMatcher(String input, String regex) {
		boolean found = false;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		StringBuilder result = new StringBuilder();
		while(matcher.find()) {
			found = true;
			result.append(String.format("found the text %s starting at index %s and ending at index %s \n",
					matcher.group(),matcher.start(),matcher.end()));
		}
		if(found) 
			return result.toString();
		return "Not found!!";
		 
		
		
	}
}
