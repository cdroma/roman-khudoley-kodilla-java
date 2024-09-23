package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author A", "Title A", 2000, "1"));
        books.add(new Book("Author B", "Title B", 2005, "2"));
        books.add(new Book("Author C", "Title C", 2010, "3"));

        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int medianYear = medianAdapter.publicationYearMedian(books);

        // Then
        assertEquals(2005, medianYear);
    }
}