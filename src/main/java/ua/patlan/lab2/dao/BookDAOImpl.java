package ua.patlan.lab2.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.patlan.lab2.entity.Book;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDAOImpl extends DAOUtils implements BookDAO {

    @Override
    public List<Book> findAll() {
        Session session = super.getCurrentSession();
        return session.createNativeQuery("SELECT * FROM books").addEntity(Book.class).list();
    }

    @Override
    public Book findByName(String name) {
        Session session = super.getCurrentSession();
        return session.get(Book.class, name);
    }

    @Override
    public void save(Book book) {
        Session session = super.getCurrentSession();
        session.save(book);
    }

    @Override
    public void update(Book book) {
        Session session = super.getCurrentSession();
        session.update(book);
    }

    @Override
    public void delete(Book book) {
        Session session = super.getCurrentSession();
        session.delete(book);
    }
}
