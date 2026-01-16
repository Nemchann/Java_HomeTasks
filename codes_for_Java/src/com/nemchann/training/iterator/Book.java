package com.nemchann.training.iterator;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year){
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book {" +
                "title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", year = " + year +
                '}';
    }
}
