package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- LIBRARY SYSTEM ---");
            System.out.println("1. Add a book");
            System.out.println("2. Delete a book");
            System.out.println("3. Show all books");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Import books from file");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Year: ");
                    int year = Integer.parseInt(sc.nextLine());

                    Book book = new Book(title, author, year);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                }

                case "2" -> {
                    library.showBooks();
                    System.out.print("Enter the number of the book to delete: ");
                    int index = Integer.parseInt(sc.nextLine()) - 1;
                    library.deleteBook(index);
                }

                case "3" -> library.showBooks();

                case "4" -> {
                    library.showBooks();
                    System.out.print("Enter the number of the book to borrow: ");
                    int index = Integer.parseInt(sc.nextLine()) - 1;
                    library.borrowBook(index);
                }

                case "5" -> {
                    library.showBooks();
                    System.out.print("Enter the number of the book to return: ");
                    int index = Integer.parseInt(sc.nextLine()) - 1;
                    library.returnBook(index);
                }

                case "6" -> {
                    System.out.print("Enter import file name (e.g. import.txt): ");
                    String fileName = sc.nextLine();
                    library.importFromFile(fileName);
                }

                case "7" -> {
                    running = false;
                    System.out.println("Exiting the application...");
                }

                default -> System.out.println("Invalid option, please try again.");
            }
        }

        sc.close();
    }
}
