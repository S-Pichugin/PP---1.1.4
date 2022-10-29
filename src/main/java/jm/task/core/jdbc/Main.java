package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl test = new UserServiceImpl();
        test.createUsersTable();

        test.saveUser("Egor", "Egorov", (byte) 25);
        System.out.println("User с именем – Egor добавлен в базу данных");
        test.saveUser("Ivan", "Ivanov", (byte) 35);
        System.out.println("User с именем – Ivan добавлен в базу данных");
        test.saveUser("Filip", "Filipov", (byte) 21);
        System.out.println("User с именем – Filip добавлен в базу данных");
        test.saveUser("Andrey", "Andreev", (byte) 46);
        System.out.println("User с именем – Andrey добавлен в базу данных");

        test.getAllUsers().stream().forEach(System.out::println);
        test.cleanUsersTable();
        test.dropUsersTable();
    }
}


