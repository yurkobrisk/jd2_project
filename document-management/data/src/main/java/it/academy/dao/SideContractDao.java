package it.academy.dao;

import java.util.List;

public interface SideContractDao<T> {

    List<T> readAll();

    T read(String id);

    String save(T person);

    String update(T person);

    void delete(String id);

}
