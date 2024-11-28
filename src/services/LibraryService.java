package services;

import models.Book;
import models.User;

import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public LibraryService() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Book added successfully: " + book);
    }

    public void addUser(String name) {
        User user = new User(name);
        users.add(user);
        System.out.println("User added successfully: " + user);
    }

    public void borrowBook(int userId, int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        book.borrow();
        System.out.println(user.getName() + " borrowed " + book.getTitle());
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isBorrowed()) {
            System.out.println("Book is not borrowed.");
            return;
        }

        book.returnBook();
        System.out.println("Book returned successfully: " + book.getTitle());
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private Book findBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    private User findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
