package de.marstusch.katas.encriptor;

public class NumberStrategy extends PartialEncriptor {

	@Override
	public String encrypt(char input) {
		return String.valueOf(input + 2);
	}
}
