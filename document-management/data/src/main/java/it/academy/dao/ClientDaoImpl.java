package it.academy.dao;

import it.academy.model.ClientDocument;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements SideContractDao<ClientDocument> {

    private SessionFactory sessionFactory;

    @Autowired
    public ClientDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ClientDocument> readAll() {
        return null;
    }

    @Override
    public ClientDocument read(String id) {
        return null;
    }

    @Override
    public String save(ClientDocument person) {
        return null;
    }

    @Override
    public String update(ClientDocument person) {
        return null;
    }

    @Override
    public void delete(String id) {
    }
}
