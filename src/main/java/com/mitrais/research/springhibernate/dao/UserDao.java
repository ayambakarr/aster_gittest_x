package com.mitrais.research.springhibernate.dao;

import com.mitrais.research.springhibernate.model.Role;
import com.mitrais.research.springhibernate.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gama Ogi Prayogo
 */
@Transactional
public interface UserDao {
    /**
     * Save user in the database
     *
     * @param user the user object that is going to be saved in database.
     */
    public void saveUser(User user) throws UserDaoException;

    /**
     * Get a list of user given the parameter that is stored in User object
     *
     * @param user parameter to be used in search
     * @return List of user. If user not found, returns a list with zero size
     */
    @Transactional(readOnly = true)
    public List<User> getUser(User user);

    /**
     * Delete user from database
     *
     * @param user the user that is going to be deleted
     */
    public void deleteUser(User user);

    /**
     * Update details of the user
     *
     * @param user the updated user object
     */
    public void updateUser(User user);

    // user role related
    public void deleteUserRole(User user, Role role);

    public void addUserRole(User user, Role role);
}
