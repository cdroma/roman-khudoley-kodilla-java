package com.kodilla.good.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Library extends Prototype<Library> {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = books.stream()
                .map(book -> new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate()))
                .collect(Collectors.toSet());
        return clonedLibrary;
    }
}
