package it.academy;

import it.academy.model.*;
import it.academy.model.enums.DocumentStatus;
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
        address1.setIndex("220010");

        Address address2 = new Address();
        address2.setCountry("Belarus");
        address2.setCity("Grodno");
        address2.setStreet("Pushkina 14");
        address2.setIndex("310083");

        ClientDocument clientDocument = new ClientDocument();
        clientDocument.setClientName("Ivan");
        clientDocument.setClientSurname("Ivanov");
        clientDocument.setClientPassportNumber("MP1477724");
        clientDocument.setClientAddress(address1);

        ProviderDocument providerDocument = new ProviderDocument();
        providerDocument.setProviderName("Sidor");
        providerDocument.setProviderSurname("Sidirov");
        providerDocument.setProviderPassportNumber("MP22344891");
        providerDocument.setProviderAddress(address2);

        Document document = new Document();
        document.setClientDocument(clientDocument);
        document.setProviderDocument(providerDocument);
        document.setCreationDate(("2021-02-14"));
        document.setCompletionDate(("2021-02-21"));
        document.setDocumentStatus(DocumentStatus.NEW);

        User user = new User();
        user.setUserName("yurko");
        user.setPassword("pass");
        document.setUser(user);


        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(address1);
            session.save(address2);
            session.save(providerDocument);
            session.save(clientDocument);
            session.save(document);
            session.save(user);
            tx.commit();
        } catch (Exception e){
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
