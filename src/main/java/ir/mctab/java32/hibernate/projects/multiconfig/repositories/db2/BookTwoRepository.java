package ir.mctab.java32.hibernate.projects.multiconfig.repositories.db2;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.CrudRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.HibernateUtil;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db2.BookTwo;
import org.hibernate.Session;

public class BookTwoRepository extends CrudRepository<BookTwo, Long> {
    @Override
    protected Class<BookTwo> getEntityClass() {
        return BookTwo.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSessionTwo();
    }

    private BookTwoRepository() {
    }

    private static BookTwoRepository bookTwoRepository;

    public static BookTwoRepository getInstance() {
        return bookTwoRepository;
    }
}
