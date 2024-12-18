package com.BookStore.App.Controller.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private int id;   
    private String title;
    private int author;
    private int publisher;
//
//     public BookResponse(int id, String title, int author, int publisher) {
//        this.id = id;
//    	this.title = title;
//        this.author = author;
//        this.publisher = publisher;
//    }
//
//     
//     
//    public int getId() {
//		return id;
//	}
//
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//
//	public String getTitle() {
//		return title;
//	}
//
//
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//
//
//	public int getAuthor() {
//		return author;
//	}
//
//
//
//	public void setAuthor(int author) {
//		this.author = author;
//	}
//
//
//
//	public int getPublisher() {
//		return publisher;
//	}
//
//
//
//	public void setPublisher(int publisher) {
//		this.publisher = publisher;
//	}
//
//
//
//	@Override
//    public String toString() {
//        return "BookResponse [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
//    }
}
