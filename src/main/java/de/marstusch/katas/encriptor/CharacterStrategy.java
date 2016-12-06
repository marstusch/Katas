package de.marstusch.katas.encriptor;

public class CharacterStrategy extends PartialEncriptor implements EncriptorStrategy {

	@Override
	public String encrypt(char input) {
		return String.valueOf((char) (input + 2));
	}

}
