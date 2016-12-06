package de.marstusch.katas.searchengine;

import java.util.List;

public interface UserRepository {

   void saveNewUser(String username, List<String> jobs);

   List<User> findBy(String job);
}
