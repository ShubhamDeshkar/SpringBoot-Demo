package com.spring.demoApplication.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static ArrayList<User> users = new ArrayList<User>();
    private static int userCount = 3;

    static {
        users.add(new User(1, "Shubham", new Date()));
        users.add(new User(2, "Rajesh", new Date()));
        users.add(new User(3, "Deshkar", new Date()));
    }

    // find all
    public List<User> findAll() {
        return users;
    }
    // save
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
    // find one
    public User findOne(int id) {
        for (User user: users
             ) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    // delete one
    public User deleteUserById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
