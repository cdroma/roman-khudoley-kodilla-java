package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()  // [1]
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));                    // [2]

        System.out.println(theResultStringOfBooks);
        System.out.println("_________________________________________________________");

        Forum forum = new Forum();

        forum.addUser(new ForumUser(23, "A.Smith", 'M', LocalDate.of(1995, 5, 26), 10));
        forum.addUser(new ForumUser(11, "AmyLee", 'K', LocalDate.of(1982, 1, 3), 2));
        forum.addUser(new ForumUser(2, "Konor33", 'M', LocalDate.of(1987, 4, 18), 8));
        forum.addUser(new ForumUser(1, "StarChick", 'K', LocalDate.of(1980, 1, 11), 65));
        forum.addUser(new ForumUser(45, "MoJoe77", 'M', LocalDate.of(1977, 9, 15), 24));
        forum.addUser(new ForumUser(345, "KatrinTT", 'K', LocalDate.of(2005, 1, 30), 48));
        forum.addUser(new ForumUser(88, "St@cy", 'K', LocalDate.of(2008, 7, 13), 0));
        forum.addUser(new ForumUser(444, "Pierce12", 'M', LocalDate.of(2010, 2, 7), 0));

        List<ForumUser> users = forum.getUserList();
        for (ForumUser user : users) {
            System.out.println(user.getUserID() + " " + user.getUsername() + " " + user.getSex() +" " + user.getBirthday() + " " + user.getPostsNumber());
        }
        System.out.println("_________________________________________________________");

        Map<Integer, ForumUser> showMap = users.stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getAge() >= 20)
                .filter(user -> user.getPostsNumber() >0)
                .collect(Collectors.toMap(ForumUser::getUserID, user -> user));

        showMap.forEach((userID, user) -> System.out.println("User ID:" + user.getUserID() + " " + "username:" + user.getUsername()));

    }
}
