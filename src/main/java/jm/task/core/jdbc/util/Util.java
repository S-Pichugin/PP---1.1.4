package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false&amp";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "m0pKFaCmPe5P";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // создание соединения через хайбернэйт
    private static SessionFactory sessionFactory;

    public static SessionFactory getConnectionHiber() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.driver_class", DB_DRIVER)
                        .setProperty("hibernate.connection.url", DB_URL)
                        .setProperty("hibernate.connection.username", DB_USERNAME)
                        .setProperty("hibernate.connection.password", DB_PASSWORD)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
                        .setProperty("hibernate.current_session_context_class", "thread")
                        .setProperty("hibernate.show_sql", "true")
                        .setProperty("hibernate.hbm2ddl.auto", "")
                        .addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
