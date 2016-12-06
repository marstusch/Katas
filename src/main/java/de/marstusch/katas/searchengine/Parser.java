package de.marstusch.katas.searchengine;

import java.util.ArrayList;
import java.util.List;

public class Parser {

   public enum Language {
      EN("s"), DE("x");

      private String pluralSuffix;

      private Language(String pluralSuffix) {
         this.pluralSuffix = pluralSuffix;
      }

      public String pluralSuffix() {
         return this.pluralSuffix;
      }
   }

   private Language language;

   public Parser(Language language) {
      this.language = language;
   }

   public List<String> parse(String input) {
      if (isNotValid(input)) {
         return noJobs();
      }

      return extractJobsFrom(input);
   }

   private ArrayList<String> extractJobsFrom(String input) {
      ArrayList<String> jobs = new ArrayList<>();
      for (String job : jobsFrom(input)) {
         String normalizedJob = normalize(job);
         if (isTooShort(normalizedJob)) {
            continue;
         }
         if (jobs.contains(normalizedJob)) {
            continue;
         }
         jobs.add(normalizedJob);
      }
      return jobs;
   }

   private String[] jobsFrom(String input) {
      return input.split(" ");
   }

   private boolean isTooShort(String input) {
      return input.length() < 4;
   }

   private String normalize(String job) {
      return makeSingular(job).toLowerCase();
   }

   private String makeSingular(String job) {
      if (job.endsWith(this.language.pluralSuffix())) {
         return job.substring(0, job.length() - 1);
      }
      return job;
   }

   private List<String> noJobs() {
      return new ArrayList<>();
   }

   private boolean isNotValid(String input) {
      return input == null || input.isEmpty();
   }
}
