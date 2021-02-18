package it.academy.dao;

import it.academy.model.Person;

public interface PersonDao {

    Person read(String id);

    String save(Person person);

    Person delete(String id);

}
