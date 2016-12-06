package de.marstusch.katas.searchengine;

import java.util.List;

public class User {
   private String name;
   private List<String> jobs;

   public User(String name) {
      this.name = name;
   }

   public String name() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<String> jobs() {
      return this.jobs;
   }

   public void setJobs(List<String> jobs) {
      this.jobs = jobs;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      User other = (User) obj;
      if (jobs == null) {
         if (other.jobs != null) {
            return false;
         }
      } else if (!jobs.equals(other.jobs)) {
         return false;
      }
      if (name == null) {
         if (other.name != null) {
            return false;
         }
      } else if (!name.equals(other.name)) {
         return false;
      }
      return true;
   }
}
