//package com.BookStore.App;
//import com.BookStore.App.Model.Book;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class BookTest {
//
//    private Book book = new Book(1,"Book1", 1,1);
//    @Test
//    public void testBook() {
//
//        assertEquals(1,book.getId());
//        assertEquals("Book1",book.getTitle());
//        assertEquals(1,book.getAuthor());
//        assertEquals(1,book.getPublisher());
//        assertFalse(book.getDeleted());
//    }
//
//    @Test
//    public void testSettersAndGetters() {
//        book.setId(2);
//        book.setTitle("Book2");
//        book.setAuthor(2);
//        book.setPublisher(2);
//        book.setDeleted(true);
//
//        assertEquals(2, book.getId());
//        assertEquals("Book2", book.getTitle());
//        assertEquals(2, book.getAuthor());
//        assertEquals(2, book.getPublisher());
//        assertTrue(book.getDeleted());
//    }
//}
