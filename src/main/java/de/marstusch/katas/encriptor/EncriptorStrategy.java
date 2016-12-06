package de.marstusch.katas.encriptor;

public interface EncriptorStrategy {
	public String encrypt(char input);
	public String encrypt(char input, char[] charsToReplace);
}
