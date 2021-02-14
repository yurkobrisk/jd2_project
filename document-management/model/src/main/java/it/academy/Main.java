package it.academy;

import it.academy.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
        SessionFactory sessionFactory =
                new MetadataSources(serviceRegistry)
                        .buildMetadata()
                        .buildSessionFactory();

        Address address1 = new Address();
        address1.setCountry("Belarus");
        address1.setCity("Minsk");
        address1.setStreet("Skarina 166");
        address1.setIndex(220010);

        Address address2 = new Address();
        address2.setCountry("Belarus");
        address2.setCity("Grodno");
        address2.setStreet("Pushkina 14");
        address2.setIndex(310083);

        Person person1 = new Person();
        person1.setName("Ivan");
        person1.setSurname("Ivanov");
        person1.setPassportNumber("MP1477724");
        person1.setAddress(address1);

        Person person2 = new Person();
        person2.setName("Sidor");
        person2.setSurname("Sidirov");
        person2.setPassportNumber("MP22344891");
        person2.setAddress(address2);

        Executor executor = new Executor();
        executor.setPerson(person1);

        Customer customer = new Customer();
        customer.setPerson(person2);

        Document document = new Document();
        document.setCustomer(customer);
        document.setExecutor(executor);
        document.setCreateDate(Date.valueOf("2021-02-14"));
        document.setStartDate(Date.valueOf("2021-02-21"));
        document.setEndDate(Date.valueOf("2022-02-22"));


        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(address1);
            session.save(address2);
            session.save(person1);
            session.save(person2);
            session.save(executor);
            session.save(customer);
            session.save(document);
            tx.commit();
        } catch (Exception e){
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
