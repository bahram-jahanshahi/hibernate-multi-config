package ir.mctab.java32.hibernate.projects.multiconfig.repositories.db1;

import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.CrudRepository;
import ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate.HibernateUtil;
import ir.mctab.java32.hibernate.projects.multiconfig.entities.db1.Customer;
import org.hibernate.Session;

public class CustomerRepository extends CrudRepository<Customer, Long> {
    private static CustomerRepository customerRepository = new CustomerRepository();

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSessionOne();
    }

    private CustomerRepository() {
    }

    public static CustomerRepository getInstance() {
        return customerRepository;
    }
}
