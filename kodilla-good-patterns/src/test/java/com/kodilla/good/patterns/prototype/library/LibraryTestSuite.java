package com.kodilla.good.patterns.prototype.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    @DisplayName("Get books test")
    void testGetBooks() {
        // Given
        Library library = new Library("City Library");
        Book book1 = new Book("Title1", "Author1", LocalDate.of(2020, 1, 1));
        Book book2 = new Book("Title2", "Author2", LocalDate.of(2021, 2, 2));
        Book book3 = new Book("Title3", "Author3", LocalDate.of(2022, 3, 3));
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        // When
        Library shallowCopiedLibrary = null;
        Library deepCopiedLibrary = null;
        try {
            shallowCopiedLibrary = library.shallowCopy();
            deepCopiedLibrary = library.deepCopy();
            shallowCopiedLibrary.name = "Shallow Copied Library";
            deepCopiedLibrary.name = "Deep Copied Library";
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // Then
        assertNotNull(shallowCopiedLibrary);
        assertNotNull(deepCopiedLibrary);
        assertEquals(3, library.getBooks().size());
        assertEquals(3, shallowCopiedLibrary.getBooks().size());
        assertEquals(3, deepCopiedLibrary.getBooks().size());
        assertEquals(library.getBooks(), shallowCopiedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepCopiedLibrary.getBooks());
    }
}
