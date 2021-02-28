package it.academy.dao;

import it.academy.model.ProviderDocument;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProviderDaoImpl<T> implements SideContractDao<ProviderDocument> {

    private SessionFactory sessionFactory;

    @Autowired
    public ProviderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ProviderDocument read(String id) {
        return null;
    }

    @Override
    public String save(ProviderDocument person) {
        return null;
    }

    @Override
    public List<ProviderDocument> readAll() {
        return null;
    }

    @Override
    public String update(ProviderDocument person) {
        return null;
    }

    @Override
    public void delete(String id) {
    }
}
