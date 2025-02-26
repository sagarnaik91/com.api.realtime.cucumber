package com.independentActions;


public class Book {
    String title;
    String author;
    int year;

    // Constructor with two parameters
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Constructor with three parameters
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year);
    }

    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        book1.displayDetails();
        book2.displayDetails();
    }
}

