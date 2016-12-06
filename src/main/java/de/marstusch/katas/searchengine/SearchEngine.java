package de.marstusch.katas.searchengine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchEngine {

   private Parser parser;
   private UserRepository userRepo;

   public SearchEngine(Parser parser, UserRepository userRepo) {
      this.parser = parser;
      this.userRepo = userRepo;
   }

   public List<User> search(String job) {
      Set<User> users = new HashSet<User>();
      for (String parsedJob : this.parser.parse(job)) {
         List<User> usersByJob = this.userRepo.findBy(parsedJob);
         users.addAll(usersByJob);
      }
      return new ArrayList<User>(users);
   }

}
