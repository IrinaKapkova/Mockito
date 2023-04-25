package me.ikapkova.mockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.lang.model.element.Name;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {
    private static User user1;
    private static User user2;

    @BeforeAll
    public static void createUsers() {
        user1 = new User();
        user2 = new User("Slava", "primer@mail.ru");
    }

    @Test
    @DisplayName("Проверка работы конструктора при передачи корректных значений")
    public void testCreateUserWithParameters() {
        assertTrue(user2.getName() != null && user2.getEmail() != null);
    }

    @Test
    @DisplayName("Проверка работы пустого конструктора без значений")
    public void testCreateUserWithOutParameters() {
        assertTrue(user1.getName() == null && user1.getEmail() == null);
    }

    @Test
    @DisplayName("Проверка факта , что при некорректном email  будет выброшено установленное исключение")
    public void testForInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new User("Slava", "anti_email"));
    }

    @Test
    @DisplayName("Проверка факта , что при некорректном email при использовании конструктора  будет выброшено установленное исключение")
    public void testForInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new User("S", "primer@mail.ru"));
    }

    @Test
    @DisplayName("Проверка факта , что при некорректном имени при использовании метода проверки имени  будет выброшено установленное исключение")
    public void testForInvalidName2() {
        assertThrows(IllegalArgumentException.class,
                () -> user2.specifyName("S")
        );
    }

    @Test
    @DisplayName("Проверка факта, что при выборе имени равном email при использовании конструктора  будет выброшено установленное исключение")
    void testForNameNotEqualsEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> new User("primer@mail.ru", "primer@mail.ru")
        );
    }

    @Test
    @DisplayName("Проверка, что при некорректном изменении email  будет выброшено установленное исключение")
    void showSetEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> user2.setEmail("S")
        );
    }

    @Test
    @DisplayName("Проверка, что при некорректном изменении имени  будет выброшено установленное исключение")
    void showSetName() {
        assertThrows(IllegalArgumentException.class,
                () -> user2.setName("S")
        );
    }
    @Test
    public void testSpecifyEmailInSetEmail() {
//      setup
        User user= spy(User.class);
        String testEmail= "primer@mail.ru";
//       run
        user.setEmail(testEmail);
//        assert
        verify(user, atLeast(1)).specifyEmail(testEmail);
    }
}