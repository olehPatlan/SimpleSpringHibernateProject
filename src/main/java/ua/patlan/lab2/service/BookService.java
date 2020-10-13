package ua.patlan.lab2.service;

import ua.patlan.lab2.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findByName(String name);
    void save(Book book);
    void update(Book book);
    void delete(Book book);
}
