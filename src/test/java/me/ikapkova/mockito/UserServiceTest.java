package me.ikapkova.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserDao dao;
    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Проверка метода checkUserExisty на возврат true при передачи корректного имени пользователя")
    void checkIfUserExistTrue() {
//      setup
        when(dao.getUserByName("test")).thenReturn(new User("test"));
//      run
        boolean userExists = userService.checkUserExist(
                new User("test"));
//      assert
        verify(dao, times(1)).getUserByName("test");
        assertTrue(userExists);
    }
    @Test
    @DisplayName("Проверка метода checkUserExisty на возврат false при передачи значения null")
    void checkIfUserExistFalse() {
//      setup
        when(dao.getUserByName("test")).thenReturn(null);
//      run
        boolean userExists = userService.checkUserExist(
                new User("test"));
//      assert
        verify(dao, times(1)).getUserByName("test");
        assertFalse(userExists);
    }
}