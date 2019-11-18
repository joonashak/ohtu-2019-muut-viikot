package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password

        // username must be at least 3 characters long and contain only characters a-z
        if (!username.matches("^[a-z]{3,}$")) {
            return true;
        }

        // password must be at least 8 characters long and contain at least on non-letter character (a-z)
        boolean nonLetter = false;

        for (char c : password.toCharArray()) {
            if (!Character.isLetter(c)) {
                nonLetter = true;
            }
        }

        if (password.length() < 8 || !nonLetter) {
            return true;
        }

        return false;
    }
}
