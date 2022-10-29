package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoJDBCImpl();
    private UserDao hibernateUserDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
//        userDao.createUsersTable();
        hibernateUserDao.createUsersTable();
    }

    public void dropUsersTable() {
//        userDao.dropUsersTable();
        hibernateUserDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
//        userDao.saveUser(name,lastName,age);
        hibernateUserDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
//        userDao.removeUserById(id);
        hibernateUserDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
        return hibernateUserDao.getAllUsers();
    }

    public void cleanUsersTable() {

//        userDao.cleanUsersTable();
        hibernateUserDao.cleanUsersTable();
    }
}
