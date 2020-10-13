package ua.patlan.lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.patlan.lab2.dao.BookDAO;
import ua.patlan.lab2.entity.Book;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> findAll() {
        bookDAO.openCurrentSession();
        List<Book> books = bookDAO.findAll();
        bookDAO.closeCurrentSession();
        return books;
    }

    @Override
    public Book findByName(String name) {
        bookDAO.openCurrentSession();
        Book book = bookDAO.findByName(name);
        bookDAO.closeCurrentSession();
        return book;
    }

    @Override
    public void save(Book book) {
        bookDAO.openCurrentSessionWithTransaction();
        bookDAO.save(book);
        bookDAO.closeCurrentSessionWithTransaction();
    }

    @Override
    public void update(Book book) {
        bookDAO.openCurrentSessionWithTransaction();
        bookDAO.update(book);
        bookDAO.closeCurrentSessionWithTransaction();
    }

    @Override
    public void delete(Book book) {
        bookDAO.openCurrentSessionWithTransaction();
        bookDAO.delete(book);
        bookDAO.closeCurrentSessionWithTransaction();
    }
}
