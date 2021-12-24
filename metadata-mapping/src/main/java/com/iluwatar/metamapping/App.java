package com.iluwatar.metamapping;

import com.iluwatar.metamapping.model.User;
import com.iluwatar.metamapping.service.UserService;
import com.iluwatar.metamapping.utils.DatabaseUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Metadata Mapping specifies the mapping
 * between classes and tables so that
 * we could treat a table of any database like a Java class.
 *
 * <p>With hibernate, we achieve list/create/update/delete/get operations.
 * Let's have a test!
 */
@Slf4j
public class App {
  /**
   * Program entry point.
   *
   * @param args command line args.
   * @throws Exception if any error occurs.
   */
  public static void main(String[] args)  throws Exception {
    // create database
    DatabaseUtil.createDataSource();
    // get service
    UserService userService = new UserService();
    // use create service to add users
    for (var user: generateSampleUsers()) {
      Integer id = userService.createUser(user);
      LOGGER.info("Add user" + user + "at" + id + ".");
    }
    // use list service to get users
    var users = userService.listUser();
    LOGGER.info(String.valueOf(users));
    // use get service to get a user
    var user = userService.getUser(1);
    LOGGER.info(String.valueOf(user));
    // change password of user 1
    user.setPassword("new123");
    // use update service to update user 1
    userService.updateUser(1, user);
    // use delete service to delete user 2
    userService.deleteUser(2);
    // close service
    userService.close();
  }

  /**
   * Generate users.
   *
   * @return list of users.
   */
  public static List<User> generateSampleUsers() {
    final var user1 = new User("ZhangSan", "zhs123");
    final var user2 = new User("LiSi", "ls123");
    final var user3 = new User("WangWu", "ww123");
    return List.of(user1, user2, user3);
  }
}
