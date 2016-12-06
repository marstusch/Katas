package de.marstusch.katas.searchengine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import de.marstusch.katas.searchengine.Parser;
import de.marstusch.katas.searchengine.Parser.Language;

public class ParserTest {

   @Test
   public void returns_empty_list_by_null() throws Exception {
      assertThat(parseInEnglish(null).isEmpty(), is(true));
   }

   @Test
   public void returns_job_by_searchterm_with_valid_job() throws Exception {
      assertListContainsJob(parseInEnglish("tester"), "tester");
   }

   @Test
   public void returns_empty_list_by_empty_searchterm() throws Exception {
      assertThat(parseInEnglish("").isEmpty(), is(true));
   }

   @Test
   public void returns_empty_list_by_searchterm_with_job_too_short() throws Exception {
      assertThat(parseInEnglish("dev").isEmpty(), is(true));
   }

   @Test
   public void returns_job_by_searchterm_with_valid_uppercase_job() throws Exception {
      assertListContainsJob(parseInEnglish("DEVELOPER"), "developer");
   }

   @Test
   public void returns_job_by_searchterm_with_valid_job_plural() throws Exception {
      assertListContainsJob(parseInEnglish("teachers"), "teacher");
   }

   @Test
   public void returns_job_by_searchterm_with_valid_job_plural_in_german() throws Exception {
      assertListContainsJob(parseInGerman("teacherx"), "teacher");
   }

   @Test
   public void returns_empty_list_by_searchterm_with_normalized_plural_job_too_short() throws Exception {
      assertThat(parseInEnglish("devs").isEmpty(), is(true));
   }

   @Test
   public void returns_jobs_by_searchterm_with_multiple_valid_job() throws Exception {
      List<String> jobs = parseInEnglish("tester1 tester2");
      assertThat(jobs.size(), is(2));
      assertThat(jobs.contains("tester1"), is(true));
      assertThat(jobs.contains("tester2"), is(true));
   }

   @Test
   public void returns_job_by_searchterm_with_multiple_equal_jobs() throws Exception {
      assertListContainsJob(parseInEnglish("teacher teacher"), "teacher");
   }

   @Test
   public void returns_empty_list_by_searchterm_only_with_seperator() throws Exception {
      assertThat(parseInEnglish("  ").isEmpty(), is(true));
   }

   @Test
   public void returns_jobs_by_complex_searchterm() throws Exception {
      List<String> jobs = parseInEnglish("Tester1 tester2s Tester2s tesTer2 dev devs");
      assertThat(jobs.size(), is(2));
      assertThat(jobs.contains("tester1"), is(true));
      assertThat(jobs.contains("tester2"), is(true));
   }

   private void assertListContainsJob(List<String> jobs, String job) {
      assertThat(jobs.size(), is(1));
      assertThat(jobs.get(0), is(job));
   }

   private List<String> parseInEnglish(String input) {
      return new Parser(Language.EN).parse(input);
   }

   private List<String> parseInGerman(String input) {
      return new Parser(Language.DE).parse(input);
   }
}

