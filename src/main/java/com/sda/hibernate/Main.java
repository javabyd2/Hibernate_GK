package com.sda.hibernate;

import com.sda.hibernate.entity.BookEntity;
import com.sda.hibernate.entity.Category;
import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import java.util.Locale;

public class Main {

    private static final SessionFactory sessionFactory;

    // blok 'static' - wykonuje się przed konstruktorem
    static{
        try{
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        BookEntity bookEntity1 = new BookEntity();
        bookEntity1.setAuthor("Jan Kowalski");
        bookEntity1.setTitle("Javascript dla dzieci");
        BookEntity bookEntity2 = new BookEntity();
        bookEntity2.setAuthor("Henryk Sienkiewicz");
        bookEntity2.setTitle("Potop");
        BookEntity bookEntity3 = new BookEntity();
        bookEntity3.setAuthor("Joanna Chyłka");
        bookEntity3.setTitle("Testament ");
        bookEntity3.setPrice(BigDecimal.valueOf(16.25));

        Transaction tx = null;
        Session session = getSession();

//        tx = session.beginTransaction();
//        session.save(bookEntity1);
//        session.save(bookEntity2);
//        session.save(bookEntity3);
//        tx.commit();

        tx = session.beginTransaction();
        List<BookEntity> bookEntityList
                = session.createCriteria(BookEntity.class).list();
        //System.out.println(bookEntityList);
        bookEntityList.stream().forEach(p-> System.out.println(p.getTitle()));

        List<BookEntity> bookEntityList1
                = session.createQuery("from "+BookEntity.class.getName()).list();

        for (BookEntity data: bookEntityList1){
            System.out.print(data.getAuthor()+", ");
            System.out.print(data.getTitle()+", ");
            System.out.println(data.getPrice());
        }

        Category cat1 = new Category();
        cat1.setCategoryName("horror");
        Category cat2 = new Category();
        cat2.setCategoryName("poezja");
        Category cat3 = new Category();
        cat3.setCategoryName("belerystyka");

//        tx.commit();
//        tx = session.beginTransaction();
//        session.save(cat1);
//        session.save(cat2);
//        session.save(cat3);
//        tx.commit();

        //tx = session.beginTransaction();
        List<Category> categoryList
                = session.createCriteria(Category.class).list();
        categoryList.stream().forEach(p-> System.out.println(p.getCategoryName()));
    }
}
