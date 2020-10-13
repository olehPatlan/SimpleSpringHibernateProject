package ua.patlan.lab2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.patlan.lab2.config.HibernateConfig;
import ua.patlan.lab2.entity.Book;
import ua.patlan.lab2.service.BookService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HibernateConfig.class);
        Book book=new Book();
        book.setName("aaaa");
        book.setAuthor("aaaa");

        Book book1=new Book();
        book1.setName("aaaa2");
        book1.setAuthor("aaaa2");

        BookService bookDAO=(BookService) context.getBean("bookServiceImpl");
        bookDAO.save(book);
        bookDAO.save(book1);
        System.out.println(bookDAO.findAll());

        book.setAuthor("1234");
        bookDAO.update(book);

        System.out.println(bookDAO.findAll());

        bookDAO.delete(book);
        System.out.println(bookDAO.findAll());
    }
}
