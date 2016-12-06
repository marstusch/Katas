package de.marstusch.katas.encriptor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

import de.marstusch.katas.encriptor.CharacterStrategy;
import de.marstusch.katas.encriptor.Encriptor;
import de.marstusch.katas.encriptor.NumberStrategy;

public class EncriptorTest {
   Encriptor characterEncryptor;
   Encriptor numberEncryptor;

   @Before
   public void initTest() {
      characterEncryptor = new Encriptor(new CharacterStrategy());
      numberEncryptor = new Encriptor(new NumberStrategy());
   }

   @Test
   public void test_encrypt_single_word() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Test");
      assertThat(encryptedWord, is("Vguv"));
   }

   @Test
   public void test_encrypt_single_word_with_special_characters() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Österreich");
      assertThat(encryptedWord, is("Øuvgttgkej"));
   }

   @Test(expected = InvalidParameterException.class)
   public void test_wrong_input_for_single_word_with_space() throws Exception {
      characterEncryptor.cryptWord(" ");
   }

   @Test(expected = InvalidParameterException.class)
   public void test_wrong_input_for_single_word_with_space_in_the_middle() throws Exception {
      characterEncryptor.cryptWord("Te st");
   }

   @Test
   public void test_encrypt_single_word_with_number() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Test123");
      assertThat(encryptedWord, is("Vguv345"));
   }

   @Test
   public void test_encrypt_single_word_with_linefeed() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Test\r\n");
      assertThat(encryptedWord, is("Vguv"));
   }

   @Test(expected = NullPointerException.class)
   public void test_encrypt_single_word_with_null_input() throws Exception {
      characterEncryptor.cryptWord(null);
   }

   @Test
   public void test_encrypt_single_word_to_number() throws Exception {
      String encryptedWord = numberEncryptor.cryptWord("Test");
      assertThat(encryptedWord, is("86103117118"));
   }

   @Test
   public void test_encrypt_single_word_to_number_with_special_characters() throws Exception {
      String encryptedWord = numberEncryptor.cryptWord("Österreich");
      assertThat(encryptedWord, is("216117118103116116103107101106"));
   }

   @Test(expected = InvalidParameterException.class)
   public void test_wrong_input_for_single_word_to_number_with_space() throws Exception {
      numberEncryptor.cryptWord(" ");
   }

   @Test(expected = InvalidParameterException.class)
   public void test_wrong_input_for_single_word_to_number_with_space_in_the_middle() throws Exception {
      numberEncryptor.cryptWord("Te st");
   }

   @Test
   public void test_encrypt_single_word_to_number_with_number() throws Exception {
      String encryptedWord = numberEncryptor.cryptWord("Test123");
      assertThat(encryptedWord, is("86103117118515253"));
   }

   @Test
   public void test_encrypt_single_word_to_number_with_linefeed() throws Exception {
      String encryptedWord = numberEncryptor.cryptWord("Test\r\n");
      assertThat(encryptedWord, is("861031171181512"));
   }

   @Test(expected = NullPointerException.class)
   public void test_encrypt_single_word_to_number_with_null_input() throws Exception {
      numberEncryptor.cryptWord(null);
   }

   @Test
   public void test_encrypt_only_some_characters_single_word_() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Test", "es");
      assertThat(encryptedWord, is("Tgut"));
   }

   @Test
   public void test_encrypt_some_characters_multiple_times_single_word_() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Test", "esees");
      assertThat(encryptedWord, is("Tgut"));
   }

   @Test(expected = NullPointerException.class)
   public void test_encrypt_only_some_characters_single_word_null_characters_to_replace() throws Exception {
      characterEncryptor.cryptWord("Test", null);
   }

   @Test
   public void test_encrypt_only_some_characters_single_word_with_special_characters() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Österreich", "ÖTs");
      assertThat(encryptedWord, is("Øuterreich"));
   }


   @Test(expected = InvalidParameterException.class)
   public void test_wrong_input_for_single_word_with_space_for_only_some_characters_to_replace() throws Exception {
      characterEncryptor.cryptWord(" ", "Xy");
   }

   @Test(expected = InvalidParameterException.class)
   public void test_wrong_input_for_single_word_with_space_in_the_middle_for_only_some_characters_to_replace()
         throws Exception {

      characterEncryptor.cryptWord("Te st", "Ty");
   }

   @Test
   public void test_encrypt_for_only_some_characters_single_word_with_number() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Test123", "T3");
      assertThat(encryptedWord, is("Vest125"));
   }

   @Test
   public void test_encrypt_for_only_some_characters_single_word_with_linefeed() throws Exception {
      String encryptedWord = characterEncryptor.cryptWord("Test\r\n", "T\r\n");
      assertThat(encryptedWord, is("Vest"));
   }

   @Test(expected = NullPointerException.class)
   public void test_single_word_only_for_some_characters_with_null_input() throws Exception {
      characterEncryptor.cryptWord(null, "xy");
   }

   @Test
   public void test_encrypt_sentence() throws Exception {
      String encryptedWord = characterEncryptor.cryptSentence("Test");
      assertThat(encryptedWord, is("Vguv"));
   }

   @Test
   public void test_encrypt_sentence_with_special_characters() throws Exception {
      String encryptedWord = characterEncryptor.cryptSentence("Österreich");
      assertThat(encryptedWord, is("Øuvgttgkej"));
   }

   @Test
   public void test_wrong_input_for_sentence_with_space() throws Exception {
      String encryptedWord = characterEncryptor.cryptSentence(" ");
      assertThat(encryptedWord, is("\""));
   }

   @Test
   public void test_wrong_input_for_sentence_with_space_in_the_middle() throws Exception {
      String encryptedWord = characterEncryptor.cryptSentence("Te st");
      assertThat(encryptedWord, is("Vg\"uv"));
   }

   @Test
   public void test_encrypt_sentence_with_number() throws Exception {
      String encryptedWord = characterEncryptor.cryptSentence("Test123");
      assertThat(encryptedWord, is("Vguv345"));
   }

   @Test
   public void test_encrypt_sentence_with_linefeed() throws Exception {
      String encryptedWord = characterEncryptor.cryptSentence("Test\r\n");
      assertThat(encryptedWord, is("Vguv"));
   }

   @Test(expected = NullPointerException.class)
   public void test_encrypt_sentence_with_null_input() throws Exception {
      characterEncryptor.cryptSentence(null);
   }
}