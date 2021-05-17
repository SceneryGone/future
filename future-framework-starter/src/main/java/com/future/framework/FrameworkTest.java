package com.future.framework;

import com.future.framework.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author future
 * @date 2021/05/07 14:58
 */
public class FrameworkTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName(null);
        new FrameworkTest().show(user);
    }

    public void show(User user) {
        String name = Optional.ofNullable(user).map(User::getName).orElse("orElse");
        System.out.println(name);

//        User user1 = new User(1, "admin");
//        User user2 = new User(2, "admin");
//        User user3 = new User(3, "admin");
//        User user4 = new User(4, "admin");
//        ArrayList<User> users = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
//
//        List<User> filterUsers = users.stream()
//                .filter(this::filterByUserId).collect(Collectors.toList());
    }

    private boolean filterByUserId(User user) {
        return user.getId() > 3 && user.getId() < 10;
    }

}
