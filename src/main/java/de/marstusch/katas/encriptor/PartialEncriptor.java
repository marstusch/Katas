package de.marstusch.katas.encriptor;

public abstract class PartialEncriptor implements EncriptorStrategy {

	@Override
	public String encrypt(char input, char[] charsToReplace) {
		for (int j = 0; j < charsToReplace.length; j++) {
			if (charsToReplace[j] == input) {
				return encrypt(input);
			}
		}
		return "" + input;
	}

}