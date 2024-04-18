package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int userID;
    private final String username;
    private final char sex;
    private final LocalDate birthday;
    private final int postsNumber;
    public ForumUser(final int userID, final String username, final char sex, final LocalDate birthday, final int postsNumber) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.postsNumber = postsNumber;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getPostsNumber() {
        return postsNumber;
    }
    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }
}
