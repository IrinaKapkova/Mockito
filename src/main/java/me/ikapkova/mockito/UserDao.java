package me.ikapkova.mockito;

import java.util.List;

public interface UserDao {
User getUserByName (String name);
List<User> findAllUsers();
}
