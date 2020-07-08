package test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.UserDao;
import test.model.User;
import test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    //    @Qualifier(value = "UserDaoImpl")
    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.getAll();
    }
}
