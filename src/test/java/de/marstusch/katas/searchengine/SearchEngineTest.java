package de.marstusch.katas.searchengine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.marstusch.katas.searchengine.Parser;
import de.marstusch.katas.searchengine.SearchEngine;
import de.marstusch.katas.searchengine.User;
import de.marstusch.katas.searchengine.UserRepository;
import de.marstusch.katas.searchengine.Parser.Language;

public class SearchEngineTest {
   @Test
   public void finds_user_for_job() throws Exception {
      UserRepository userRepo = new UserRepository() {

         @Override
         public void saveNewUser(String username, List<String> jobs) {
            throw new UnsupportedOperationException();
         }

         @Override
         public List<User> findBy(String job) {
            List<User> users = new ArrayList<>();
            if (job.equals("teacher")) {
               users.add(new User("franz"));
            } else {
               fail();
            }
            return users;
         }

      };

      Parser parser = new Parser(Language.EN);
      SearchEngine engine = new SearchEngine(parser, userRepo);
      List<User> users = engine.search("teacher");
      assertThat(users.size(), is(1));
      assertThat(users.get(0).name(), is("franz"));
   }

   @Test
   public void finds_user_for_multiple_jobs() throws Exception {
      UserRepository userRepo = new UserRepository() {

         @Override
         public void saveNewUser(String username, List<String> jobs) {
            throw new UnsupportedOperationException();
         }

         @Override
         public List<User> findBy(String job) {
            List<User> users = new ArrayList<>();
            if (job.equals("teacher")) {
               users.add(new User("franz"));
            } else if (job.equals("driver")) {
               users.add(new User("franz"));
            } else {
               fail();
            }
            return users;
         }

      };

      Parser parser = new Parser(Language.EN);
      SearchEngine engine = new SearchEngine(parser, userRepo);
      List<User> users = engine.search("teacher driver");
      assertThat(users.size(), is(1));
      assertThat(users.get(0).name(), is("franz"));
   }


}
