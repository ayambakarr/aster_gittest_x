package com.mitrais.research.springhibernate.dao;

import com.mitrais.research.springhibernate.model.Role;
import com.mitrais.research.springhibernate.model.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Gama Ogi Prayogo
 */
@Repository
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao{

    @Override
    public void saveUser(User user) throws UserDaoException{
        // store the create date before saving to database
        Date now = Calendar.getInstance().getTime();
        user.setCreateDate(new Timestamp(now.getTime()));
        try {
            getSessionFactory().getCurrentSession().save(user);
        } catch (HibernateException e) {
            throw new UserDaoException(e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> getUser(User user) {
        // implementation of get user using Hibernate Criteria API
        Criteria userSearchCritera = getSessionFactory().getCurrentSession().createCriteria(User.class) ;
        if (user.getId() !=  null){
            userSearchCritera.add(Restrictions.eq("id", user.getId()));
        }
        userSearchCritera.add(Restrictions.like("fullName", "%" + user.getFullName() + "%"));

        return userSearchCritera.list();
    }

    @Override
    public void deleteUser(User user) {
        getSessionFactory().getCurrentSession().delete(user);
    }

    @Override
    public void updateUser(User user) {
        Date now = Calendar.getInstance().getTime();
        user.setLastUpdate(now);
        getSessionFactory().getCurrentSession().update(user);
    }

    @Override
    public void deleteUserRole(User user, Role role) {

    }

    @Override
    public void addUserRole(User user, Role role) {

    }
}
