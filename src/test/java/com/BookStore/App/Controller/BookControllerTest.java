//package com.BookStore.App.Controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.isA;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.BookStore.App.Controller.POJO.BookBean;
//import com.BookStore.App.Model.Book;
//import com.BookStore.App.Service.BookService;
//
//@RunWith(MockitoJUnitRunner.class)
//class BookControllerTest {
//
//    @InjectMocks
//    private BookController bookController;
//
//    @Mock
//    private BookService bookService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testAddBook() {
//        BookBean bookBean = new BookBean();
//        
//        // Mocking BookService to perform the addBook operation
//        doNothing().when(bookService).addBook(isA(Book.class));
//
//        final ResponseEntity<String> response = bookController.addBook(bookBean);
//
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        assertEquals("Book added successfully", response.getBody());
//    }
//
//    @Test
//    void testAddBook_InvalidCredentials() {
//        // No longer need this test, as validation is removed in the controller.
//    }
//
//    @Test
//    void testGetBooks() {
//        // Mocking BookService to return a list of books
//        List<Book> mockBooks = new ArrayList<>();
//        Book mockBook = new Book();
//        mockBooks.add(mockBook);
//
//        when(bookService.getBooks()).thenReturn(mockBooks);
//
//        final ResponseEntity<List<BookBean>> response = bookController.getBooks();
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(mockBooks.size(), response.getBody().size());
//    }
//
//    @Test
//    void testRemove() {
//        int id = 1;
//
//        // Mocking BookService to remove a book by ID
//        doNothing().when(bookService).remove(id);
//
//        ResponseEntity<String> response = bookController.remove(id);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Book with id " + id + " removed Successfully", response.getBody());
//    }
//
//    @Test
//    void testDelete() {
//        int id = 1;
//
//        // Mocking BookService to delete a book by ID
//        doNothing().when(bookService).delete(id);
//
//        ResponseEntity<String> response = bookController.delete(id);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals("Book with id " + id + " deleted Successfully", response.getBody());
//    }
//
//    @Test
//    void testUpdate() {
//        BookBean bookBean = new BookBean();
//        int id = 1;
//
//        // Mocking BookService to update a book
//        doNothing().when(bookService).update(id, isA(Book.class));
//
//        ResponseEntity<String> response = bookController.update(id, bookBean);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertTrue(response.getBody().contains("updated Successfully"));
//    }
//
//    @Test
//    void testGetBook() {
//        int id = 1;
//
//        // Mocking BookService to return a book by ID
//        Book mockBook = new Book();
//        when(bookService.getById(id)).thenReturn(mockBook);
//
//        final ResponseEntity<BookBean> response = bookController.getBook(id);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    void testGetBooksByTitle() {
//        String title = "Test Book";
//
//        // Mocking BookService to return a book by title
//        Book mockBook = new Book();
//        when(bookService.getByTitle(title)).thenReturn(mockBook);
//
//        final ResponseEntity<BookBean> response = bookController.getBooksByTitle(title);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    void testGetBooksByAuthor() {
//        String author = "Test Author";
//
//        // Mocking BookService to return books by author
//        List<Book> mockBooks = new ArrayList<>();
//        Book mockBook = new Book();
//        mockBooks.add(mockBook);
//        when(bookService.getByAuthor(author)).thenReturn(mockBooks);
//
//        final ResponseEntity<List<BookBean>> response = bookController.getBooksByAuthor(author);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(mockBooks.size(), response.getBody().size());
//    }
//
//    @Test
//    void testGetBooksByPublisher() {
//        String publisher = "Test Publisher";
//
//        // Mocking BookService to return books by publisher
//        List<Book> mockBooks = new ArrayList<>();
//        Book mockBook = new Book();
//        mockBooks.add(mockBook);
//        when(bookService.getByPublisher(publisher)).thenReturn(mockBooks);
//
//        final ResponseEntity<List<BookBean>> response = bookController.getBooksByPublisher(publisher);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(mockBooks.size(), response.getBody().size());
//    }
//
//    @Test
//    void testGetBooksByAuthorAndPublisher() {
//        String author = "Test Author";
//        String publisher = "Test Publisher";
//
//        // Mocking BookService to return books by author and publisher
//        List<Book> mockBooks = new ArrayList<>();
//        Book mockBook = new Book();
//        mockBooks.add(mockBook);
//        when(bookService.getByAuthorAndPublisher(author, publisher)).thenReturn(mockBooks);
//
//        final ResponseEntity<List<BookBean>> response = bookController.getBooksByAuthorAndPublisher(author, publisher);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(mockBooks.size(), response.getBody().size());
//    }
//}
