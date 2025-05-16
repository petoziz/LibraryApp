package com.library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private static final String FILE_NAME = "library.txt";

    public Library() {
        loadFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        saveToFile();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.printf("%-4s %-30s %-20s %-6s %-10s%n", "#", "Title", "Author", "Year", "Status");
            System.out.println("---------------------------------------------------------------------");

            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                String status = book.isBorrowed() ? "Borrowed" : "Available";
                System.out.printf("%-4d %-30s %-20s %-6d %-10s%n",
                        (i + 1),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getYear(),
                        status);
            }
        }
    }

    public void borrowBook(int index) {
        if (isValidIndex(index)) {
            Book book = books.get(index);
            if (!book.isBorrowed()) {
                book.borrow();
                System.out.println("Book has been borrowed.");
                saveToFile();
            } else {
                System.out.println("Book is already borrowed.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    public void returnBook(int index) {
        if (isValidIndex(index)) {
            Book book = books.get(index);
            if (book.isBorrowed()) {
                book.returnBook();
                System.out.println("Book has been returned.");
                saveToFile();
            } else {
                System.out.println("Book was not borrowed.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    public void deleteBook(int index) {
        if (isValidIndex(index)) {
            Book removed = books.remove(index);
            saveToFile();
            System.out.println("Book \"" + removed.getTitle() + "\" has been deleted.");
        } else {
            System.out.println("Invalid book number.");
        }
    }

    public void importFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Import file not found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String title = parts[0];
                    String author = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    books.add(new Book(title, author, year));
                    count++;
                }
            }
            saveToFile();
            System.out.println(count + " books have been imported.");
        } catch (Exception e) {
            System.out.println("Error during import: " + e.getMessage());
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < books.size();
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.println(book.getTitle() + ";" + book.getAuthor() + ";" + book.getYear() + ";" + book.isBorrowed());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    Book book = new Book(parts[0], parts[1], Integer.parseInt(parts[2]));
                    if (Boolean.parseBoolean(parts[3])) {
                        book.borrow();
                    }
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}
