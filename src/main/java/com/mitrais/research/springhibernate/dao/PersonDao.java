package com.mitrais.research.springhibernate.dao;

import com.mitrais.research.springhibernate.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gama Ogi Prayogo
 */
@Transactional
public interface PersonDao {
    void updatePerson (Person person);
    void deletePerson (Person person) ;
    void savePerson(Person person) ;
    @Transactional (readOnly = true)
    List getPeople(Person paramater) ;
}