package it.academy.dao;

import it.academy.model.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("documentDaoImpl")
public class DocumentDaoImpl implements DocumentDao {

    // inject SessionFactory через конструктор
    private SessionFactory sessionFactory;

    @Autowired
    public DocumentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Document> readAllDocuments() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Document", Document.class)
                .list();
    }

    @Override
    public Document readDocument(String id) {
        return sessionFactory
                .getCurrentSession()
                .get(Document.class, id);
    }

    @Override
    public String saveDocument(Document document) {
        Session session = sessionFactory.getCurrentSession();
        String id = (String) session.save(document);
        return id;
    }

    @Override
    public String updateDocument(Document document) {
        //TODO think about update method in DocumentDao
        return null;
    }

    @Override
    public void deleteDocument(String id) {
        Session session = sessionFactory.getCurrentSession();
        Document document = session.get(Document.class, id);
        if (document != null) {
            session.delete(document);
        }
    }
}
