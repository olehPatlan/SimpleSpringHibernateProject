package ua.patlan.lab2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.patlan.lab2.config.HibernateConfig;
import ua.patlan.lab2.entity.Book;
import ua.patlan.lab2.service.BookService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(HibernateConfig.class);
        Book book1=new Book();
        book1.setName("aaaa");
        book1.setAuthor("aaaa");

        Book book2=new Book();
        book2.setName("aaaa2");
        book2.setAuthor("aaaa2");

        BookService bookDAO=(BookService) context.getBean("bookServiceImpl");

        bookDAO.save(book1);
        bookDAO.save(book2);

        System.out.println("bookDAO.findAll()");
        System.out.println(bookDAO.findAll());


        System.out.println("Setting author book1");
        book1.setAuthor("1234");
        bookDAO.update(book1);
        System.out.println(bookDAO.findAll());

        System.out.println("Deleting book1");
        bookDAO.delete(book1);
        System.out.println(bookDAO.findAll());
    }
}
