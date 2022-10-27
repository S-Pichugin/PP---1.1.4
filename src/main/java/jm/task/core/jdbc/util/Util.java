package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;


public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "m0pKFaCmPe5P";


    public static Connection getConnection(){
        Connection connection = null;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private static SessionFactory sessionFactory;
    static {
        try {
            Properties prop= new Properties();
            //provide the required properties
            prop.setProperty("hibernate.connection.url",  "jdbc:mysql://localhost:3306/mydbtest");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "m0pKFaCmPe5P");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            //create a configuration
            Configuration config = new Configuration();
            //provide all properties to this configuration
            config.setProperties(prop);
            //add classes which are mapped to database tables.
            config.addAnnotatedClass(User.class);
            //initialize session factory
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    /**
     * Return session for every database transaction from this static method
     */
    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration();
//
//                Properties settings = new Properties();
//                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                settings.put(Environment.URL, DB_URL);
//                settings.put(Environment.USER, DB_USERNAME);
//                settings.put(Environment.PASS, DB_PASSWORD);
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//                settings.put(Environment.SHOW_SQL, "true");
//
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//                settings.put(Environment.HBM2DDL_AUTO, "create");
//
//                configuration.setProperties(settings);
//
//                configuration.addAnnotatedClass(User.class);
//
//                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties()).build();
//
//                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return sessionFactory;
    }
