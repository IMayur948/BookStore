package com.BookStore.App.Controller.POJO;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
	
	@NotNull
    private String title;
    
	@NotNull
	private int author;
    
	@NotNull
	private int publisher; 
    
    public BookRequest() {
    	
    }

    public BookRequest( String title, int author, int publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
 
    }
 
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

	@Override
	public String toString() {
		return "BookBean [ title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
    
    
}
