package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.Dao;
import web.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final Dao userDao;


    public UserServiceImpl(Dao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public User updateUser(int id) {
        User user = userDao.getById(id);
        user.toString();
        return user;
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
}