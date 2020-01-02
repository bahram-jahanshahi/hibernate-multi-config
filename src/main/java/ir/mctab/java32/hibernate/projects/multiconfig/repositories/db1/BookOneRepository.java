package ir.mctab.java32.hibernate.projects.multiconfig.repositories.db1;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.CrudRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.HibernateUtil;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.BookOne;
import org.hibernate.Session;

public class BookOneRepository extends CrudRepository<BookOne, Long> {
    @Override
    protected Class<BookOne> getEntityClass() {
        return BookOne.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSessionOne();
    }

    private BookOneRepository(){}

    private static BookOneRepository bookOneRepository;

    public static BookOneRepository getInstance() {
        return bookOneRepository;
    }
}
