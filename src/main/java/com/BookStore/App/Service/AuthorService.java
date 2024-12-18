package com.BookStore.App.Service;

import com.BookStore.App.Model.Author;
import com.BookStore.App.Service.Exception.AddressNotFoundException;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(int id);

    Author addAuthor(Author author, int addressId) throws AddressNotFoundException;

    Author updateAuthor(int id, Author author);

    void deleteAuthor(int id);

}
