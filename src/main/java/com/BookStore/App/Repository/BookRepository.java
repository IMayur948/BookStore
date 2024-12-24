package com.BookStore.App.Repository;

import com.BookStore.App.Model.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	Optional<Book> findByTitle(String title);
	
	List<Book> findByPublisherId(int publisher);

	List<Book> findByAuthorId(int author);
	
}