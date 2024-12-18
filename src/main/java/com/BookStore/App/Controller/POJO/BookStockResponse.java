package com.BookStore.App.Controller.POJO;

public class BookStockResponse {
    
    private int id;
    private int bookId;
    private int stockIn;
    private int stockOut;

    // Constructors
    public BookStockResponse() {}

    public BookStockResponse(int id, int bookId, int stockIn, int stockOut) {
        this.id = id;
        this.bookId = bookId;
        this.stockIn = stockIn;
        this.stockOut = stockOut;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStockIn() {
        return stockIn;
    }

    public void setStockIn(int stockIn) {
        this.stockIn = stockIn;
    }

    public int getStockOut() {
        return stockOut;
    }

    public void setStockOut(int stockOut) {
        this.stockOut = stockOut;
    }

    @Override
    public String toString() {
        return "BookStockBean{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", stockIn=" + stockIn +
                ", stockOut=" + stockOut +
                '}';
    }
}
