package de.marstusch.katas.encriptor;

import java.security.InvalidParameterException;

public class Encriptor {

	private EncriptorStrategy strategy;

	public Encriptor(EncriptorStrategy strategy) {
		this.strategy = strategy;
	}

	public String cryptWord(String word) {
		return encrypt(checkIsSingleWord(word));
	}

	public String cryptSentence(String sentence) {
		return encrypt(sentence);
	}

	public String cryptWord(String word, String charsToReplace) {
		checkIsSingleWord(word);

		char[] wordArray = word.toCharArray();
		String result = "";
		for (int i = 0; i < wordArray.length; i++) {
			result += strategy.encrypt(wordArray[i], charsToReplace.toCharArray());
		}
		return String.valueOf(result);
	}

	private String checkIsSingleWord(String word) throws InvalidParameterException {
		if (word.contains(" "))
			throw new InvalidParameterException();
		return word;
	}

	private String encrypt(String input) {
		char[] wordArray = input.toCharArray();
		String newWord = "";
		for (int i = 0; i < input.length(); i++) {
			newWord += strategy.encrypt(wordArray[i]);
		}
		return newWord;
	}
}
