package me.ikapkova.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static me.ikapkova.mockito.UserTestConstants.*;

class UserDaoTest {
    private final UserDao dao = new UserDaoImpl();

    @Test
    void testGetUserByName() {
        User user =dao.getUserByName("Slava");
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getName(), "Slava");
    }
    @Test
    void testGetUserByNameIsNull() {
        Assertions.assertNull(dao.getUserByName("user"));
    }

    @Test
    void testFindAllUsers() {
    }
    @ParameterizedTest
    @MethodSource("provideParamsForUserDaoTests")
    public void shouldTestUserByUserName(String name) {
        User user =dao.getUserByName(name);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.getName(),name);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidParamsForUserDaoTests")
    public void shouldTestUserByUserNameIsNull(String name) {
        Assertions.assertNull(dao.getUserByName(name));
    }
    public static Stream<Arguments> provideParamsForUserDaoTests() {
        return Stream.of(
                Arguments.of(CORRECT_USER_NAME1),
                Arguments.of(CORRECT_USER_NAME2));
    }
    public static Stream<Arguments> provideInvalidParamsForUserDaoTests() {
        return Stream.of(
                Arguments.of(INVALID_USER_NAME1),
                Arguments.of(INVALID_USER_NAME2));
    }


}