package ir.mctab.java32.hibernate.projects.multiconfig.repositories.h2;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.CrudRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.HibernateUtil;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.h2.BookH2;
import org.hibernate.Session;

public class BookH2Repository extends CrudRepository<BookH2, Long> {
    private static BookH2Repository bookH2Repository;

    @Override
    protected Class<BookH2> getEntityClass() {
        return BookH2.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSessionH2();
    }

    private BookH2Repository() {

    }

    public static BookH2Repository getInstance() {
        if (bookH2Repository == null) {
            bookH2Repository = new BookH2Repository();
        }
        return bookH2Repository;
    }
}
