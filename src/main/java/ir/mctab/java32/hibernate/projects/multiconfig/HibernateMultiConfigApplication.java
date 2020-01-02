package ir.mctab.java32.hibernate.projects.multiconfig;

import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.BookOne;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db2.BookTwo;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.db1.BookOneRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.db2.BookTwoRepository;

public class HibernateMultiConfigApplication {

    public HibernateMultiConfigApplication() {
        testTwoDB();;
    }

    public static void main(String[] args) {
        new HibernateMultiConfigApplication();
    }

    void testTwoDB() {
        // db1
        BookOneRepository bookOneRepository = BookOneRepository.getInstance();
        // db2
        BookTwoRepository bookTwoRepository = BookTwoRepository.getInstance();

        bookOneRepository
                .save(
                        new BookOne(
                            "The journey of soul",
                            "458782120000"
                        )
                );

        bookTwoRepository
                .save(
                        new BookTwo(
                                "The Sophia's world",
                                "785450015100"
                        )
                );
    }
}
