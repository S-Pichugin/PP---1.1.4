package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public void main(String[] args) throws SQLException {
        UserServiceImpl test = new UserServiceImpl();
        test.createUsersTable();

        test.saveUser("Egor","Ivanov", (byte) 25);
        System.out.println("User с именем – Egor добавлен в базу данных");
        test.saveUser("Ivan","Petrov", (byte) 35);
        System.out.println("User с именем – Ivan добавлен в базу данных");
        test.saveUser("Emely","Gazgolder", (byte) 21);
        System.out.println("User с именем – Emely добавлен в базу данных");
        test.saveUser("Gruz","Kaspiyskiy", (byte) 46);
        System.out.println("User с именем – Gruz добавлен в базу данных");

        test.getAllUsers().stream().forEach(System.out::println);

        test.dropUsersTable();

        test.cleanUsersTable();
    }
}
