package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> userList;
    public Forum() {
        this.userList = new ArrayList<>();
    }

    public void addUser(ForumUser user) {
        userList.add(user);
    }
    public List<ForumUser> getUserList() {
        return userList;
    }
}
