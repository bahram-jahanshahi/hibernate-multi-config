package ir.mctab.java32.hibernate.projects.multiconfig;

import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.BookOne;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.Customer;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.CustomerFile;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.CustomerInterface;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.embeddables.ContactInfo;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.embeddables.CustomerFileStatus;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.enums.CustomerType;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db2.BookTwo;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.h2.BookH2;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.db1.BookOneRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.db1.CustomerRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.db2.BookTwoRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.repositories.h2.BookH2Repository;

import java.util.Collections;
import java.util.Set;

public class HibernateMultiConfigApplication {

    public HibernateMultiConfigApplication() {
        // testTwoDB();;
        // testH2();
        // testCrm();
        testCrm2();
    }

    public static void main(String[] args) {
        new HibernateMultiConfigApplication();
    }

    void testCrm() {
        CustomerRepository customerRepository = CustomerRepository.getInstance();

        String customerTitle = "Mellat Bank";
        CustomerType customerType = CustomerType.Organ;
        Long crmId = 4501L;
        String mobile = "091234568974";
        String phoneNumber = "02145786532";
        String email = "info@MellanBank.ir";
        String fileTitle = "Sale 1398";
        CustomerFileStatus status = CustomerFileStatus.Active;
        String interfaceName = "Ali";
        String interfaceFamily = "Jordan";
        String interfaceMobile = "09121001001";
        String interfacePhoneNumber = "02144558789";
        String interfaceEmail = "ali.jordan@MellanBank.ir";

        Customer customer = new Customer(
                customerTitle,
                customerType,
                crmId,
                new ContactInfo(mobile, phoneNumber, email),
                "",
                Collections.emptySet()
        );

        CustomerFile customerFile = new CustomerFile(
                fileTitle,
                status,
                customer,
                Collections.emptySet()
        );

        customer
                .setFiles(
                        Set.of(customerFile)
                );

        CustomerInterface customerInterface = new CustomerInterface(
                interfaceName,
                interfaceFamily,
                new ContactInfo(interfaceMobile, interfacePhoneNumber, interfaceEmail),
                customerFile
        );

        customerFile
                .setInterfaces(
                        Collections.singleton(customerInterface)
                );

        customerRepository
                .save(customer);
    }

    void testCrm2() {
        CustomerRepository customerRepository = CustomerRepository.getInstance();

        Customer customer1 = customerRepository
                .findById(1L);

        customer1
                .getFiles()
                .forEach(file -> {
                    System.out.println(file.getId());
                });

        /*customer1
                .getFiles()
                .removeIf(customerFile -> customerFile.getId().equals(2L));*/
        customer1
                .getFiles()
                .forEach(customerFile -> {
                    customerFile.setTitle("Support 1398");
                });

        customer1
                .setTitle("Melli Bank");

        System.out.println("---------------------------");
        /*customer1
                .getFiles()
                .forEach(file -> {
                    System.out.println(file.getId());
                });*/

        customerRepository
                .update(customer1);
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
