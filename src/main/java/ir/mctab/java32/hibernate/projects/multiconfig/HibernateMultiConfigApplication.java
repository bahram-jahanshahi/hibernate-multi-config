package ir.mctab.java32.hibernate.projects.multiconfig;

import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.BookOne;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db2.BookTwo;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.h2.BookH2;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.db1.BookOneRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.db2.BookTwoRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.h2.BookH2Repository;

public class HibernateMultiConfigApplication {

    public HibernateMultiConfigApplication() {
        // testTwoDB();;
        testH2();
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

    void testH2() {
        BookH2Repository bookH2Repository = BookH2Repository.getInstance();

        bookH2Repository
                .save(
                        new BookH2(
                            "Harry Potter",
                            "12300841100"
                        )
                );

        bookH2Repository
                .findAll()
                .forEach(System.out::println);
    }
}
