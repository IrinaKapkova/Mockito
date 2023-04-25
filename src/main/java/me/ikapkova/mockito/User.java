package me.ikapkova.mockito;

import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.regex.Pattern;

public class User {
    private String  name;
    private String email;
    public User(String name) {
        this.name = specifyName(name);
    }
    public User(String name, String email) {
        this.name = specifyName(name);
        if (!name.equals(email))
        {
        this.email = specifyEmail(email); } else {
            throw new IllegalArgumentException("Email is the same as name");
        }
    }
    public User() {
    }

    public String specifyEmail(String email) {
        if ((email != null && !email.isEmpty() && !email.isBlank())
                && Pattern.matches("((\\w+[\\.-]?\\w+)+@(\\w+[\\-.]?\\w+)+[\\.]{1}[a-z]{2,4})", email)) {
            return this.email = email;
        } else {
            throw new IllegalArgumentException("Email entered incorrectly");
        }
    }

    public  String specifyName(String name) {
        if ((name != null && !name.isEmpty() && !name.isBlank()) && Pattern.matches("\\w{2,15}", name)) {
            return this.name = name;
        } else {
            throw new IllegalArgumentException("Name entered incorrectly" + name);
        }
    }

    public void setEmail(String email) {
        this.email = specifyEmail(email);
    }

    public void setName(String name) {
        this.name = specifyName(name);
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

