package com.mitrais.research.springhibernate.dao;

import com.mitrais.research.springhibernate.model.Person;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Gama Ogi Prayogo
 */
@Repository
public class PersonDaoImpl extends AbstractDao implements PersonDao {

    @Override
    public void updatePerson(Person person) {
        Date now = Calendar.getInstance().getTime();
        person.setLastUpdate(now);
        getSessionFactory().getCurrentSession().update(person);
    }

    @Override
    public void deletePerson(Person person) {
        getSessionFactory().getCurrentSession().delete(person);
    }

    @Override
    public void savePerson(Person person) {
        Date now = Calendar.getInstance().getTime();
        person.setCreateDate(new Timestamp(now.getTime()));
        getSessionFactory().getCurrentSession().save(person);
    }

    @Override
    @SuppressWarnings("unchecked")  // yes, i know bout the list<Person>, now shut up
    public List<Person> getPeople(Person paramater) {
        // Implementation of getter using Hibernate HQL
        Query query = getSessionFactory().getCurrentSession().createQuery("from Person where fullName = ?")  ;
        query.setString(0,paramater.getFullName());
        return query.list();
    }
}
