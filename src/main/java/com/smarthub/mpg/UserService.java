package com.smarthub.mpg;

import com.smarthub.mpg.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: james
 * Date: 9/26/14
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserService {

    public List<User> getUsers() {
        List<User> user = new ArrayList<User>();
        user.add(new User(1L,"James","Barbosa","MyEmail"));
        return user;
    }

    public User getUserById(Long id) {
        if(id == 1)
        return new User(1L,"James","Barbosa","MyEmail");
        else
        return null;
    }

}
