package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(books.size() + 1);
        books.add(book);
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public void updateBook(Book updatedBook) {
        books.stream()
            .filter(book -> book.getId() == updatedBook.getId())
            .findFirst()
            .ifPresent(book -> {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
            });
    }

    public void deleteBookById(Long id) {
        books.removeIf(book -> book.getId() == id);
    }
}
