package com.mitrais.research.springhibernate.dao;

import com.mitrais.research.springhibernate.BaseTest;
import com.mitrais.research.springhibernate.model.Role;
import com.mitrais.research.springhibernate.model.User;
import com.mitrais.research.springhibernate.util.StringHasher;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Gama Ogi Prayogo
 */
@ContextConfiguration({"classpath:spring-database.xml"})
public class UserDaoImplTest { 
//extends BaseTest {

//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private RoleDao roleDao;
//
//    private User createTestUser() {
//        User testUser = new User();
//        testUser.setUsername("some_user_name");
//        testUser.setFullName("Test User");
//        testUser.setGender("M");
//        testUser.setPassword(StringHasher.md5("some"));
//        testUser.setEmail("name@address.com");
//        return testUser;
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testInsertAndGetUser() {
//        User user = createTestUser();
//        userDao.saveUser(user);
//        List<User> users = userDao.getUser(user);
//        assertNotNull(users);
//        assertEquals(1, users.size());
//        user = users.get(0);
//        // confirm all properties has been retrieved correctly
//        assertEquals("Test User", user.getFullName());
//        assertEquals("some_user_name", user.getUsername());
//        assertEquals(StringHasher.md5("some"), user.getPassword());
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testDeleteUser() {
//        User testUser = createTestUser();
//        userDao.saveUser(testUser);
//        // confirm save user ok
//        List<User> users = userDao.getUser(testUser);
//        assertTrue(users.size() == 1);
//        User savedUser = users.get(0);
//        assertEquals("some_user_name", savedUser.getUsername());
//        // now test delete
//        userDao.deleteUser(savedUser);
//        // confirm deletion
//        assertTrue(userDao.getUser(savedUser).size() == 0);
//    }
//
//
//    @Test (expected = UserDaoException.class)
//    @Transactional
//    @Rollback(true)
//    public void testSaveDuplicateUser() {
//        userDao.saveUser(createTestUser());
//        userDao.saveUser(createTestUser());
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testUpdateUser() {
//        userDao.saveUser(createTestUser());
//        User u = userDao.getUser(createTestUser()).get(0);
//        u.setFullName("test update user");
//        userDao.updateUser(u);
//        u = userDao.getUser(u).get(0);
//        assertEquals("test update user", u.getFullName());
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true)  @Ignore
//    public void testAddUserRole() {
//        Role parameter = new Role();
//        parameter.setRoleName("guest");
//        Role guestRole = roleDao.get(parameter);
//        User user = createTestUser();
//        // save user
//        userDao.saveUser(user);
//        // give role
//        userDao.addUserRole(user, guestRole);
//        // now confirm that the role has been saved.
//        List<User> userList = userDao.getUser(user);
//        user = userList.get(0);
//        List<Role> roles = user.getRoles();
//        // confirm the number of role that the user has
//        assertTrue((roles.size() == 1));
//        Role role = roles.get(0);
//        // confirm the role
//        assertEquals(guestRole.getRoleName(), role.getRoleName());
//        assertEquals(guestRole.getDescription(), role.getDescription());
//    }
//
//    @Test
//    @Transactional
//    @Rollback(true) @Ignore
//    public void testAddTheSameRoleTwice() {
//        assertTrue(false); // let the test unit fails, when incomplete
//    }
//
//
//    @Test
//    @Transactional
//    @Rollback(true)          @Ignore
//    public void testDeleteUserRole() {
//        Role parameter = new Role();
//        parameter.setRoleName("guest");
//        Role guestRole = roleDao.get(parameter);
//        User user = createTestUser();
//        user.setUsername("test_delete_user_role");
//        // save user
//        userDao.saveUser(user);
//        // give role
//        userDao.addUserRole(user, guestRole);
//        // now confirm that the role has been saved.
//        List<User> userList = userDao.getUser(user);
//        user = userList.get(0);
//        List<Role> roles = user.getRoles();
//        Role role = roles.get(0);
//        // confirm the role
//        assertEquals(guestRole.getRoleName(), role.getRoleName());
//        assertEquals(guestRole.getDescription(), role.getDescription());
//
//        userDao.deleteUserRole(user, role);
//        // now get user again from database
//        userList = userDao.getUser(user);
//        user = userList.get(0);
//        roles = user.getRoles();
//        // confirm deletion by checking the number of roles
//        assertTrue(roles.size() == 0);
//    }
//
//    @Test
//    public void testSearchUserNotInDatabase () {
//        String username = "AStupidUserNameThatNoOneUse" ;
//        User parameter = new User();
//        parameter.setUsername(username);
//        assertNotNull(userDao.getUser(parameter));
//        assertTrue(userDao.getUser(parameter).size() == 0 );
//    }
}
