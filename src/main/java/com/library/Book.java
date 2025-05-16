package com.library;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean borrowed;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrow() {
        this.borrowed = true;
    }

    public void returnBook() {
        this.borrowed = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + year + ")" + (borrowed ? " [BORROWED]" : "");
    }
}
