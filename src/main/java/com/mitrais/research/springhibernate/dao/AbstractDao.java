package com.mitrais.research.springhibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Gama Ogi Prayogo
 */

@Repository
public abstract class AbstractDao {
   private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory=  sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
}
