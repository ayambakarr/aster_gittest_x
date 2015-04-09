package com.mitrais.research.springhibernate.dao;

/**
 * @author Gama Ogi Prayogo
 */

import com.mitrais.research.springhibernate.BaseTest;
import com.mitrais.research.springhibernate.model.Address;
import com.mitrais.research.springhibernate.model.Person;
import com.mitrais.research.springhibernate.model.Phone;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Gama Ogi Prayogo
 */
@ContextConfiguration({"classpath:spring-database.xml"})
public class PersonDaoImplTest{ 
//extends BaseTest {
//
//    @Autowired
//    private PersonDao dao;
//
//    private Person createTestPerson() {
//        Person aTestPerson = new Person();
//        aTestPerson.setFullName("Some idiotic name");
//        aTestPerson.setDateOfBirth(new GregorianCalendar(1998, 5, 18).getTime());
//        aTestPerson.setGender("M");
//        aTestPerson.setAddress(new Address("Some address"));
//        Phone fakePhone = new Phone("fake phone", "1232124");
//        Phone anotherFakephone = new Phone("some other fake phone", "131521");
//        List<Phone> phones = new ArrayList<Phone>();
//        phones.add(fakePhone);
//        phones.add(anotherFakephone);
//        aTestPerson.setPhones(phones);
//        return aTestPerson;
//    }
//
//    @Test
//    @Transactional
//    @Rollback (true)
//    @SuppressWarnings("unchecked")
//    public void testInsertAndGet() {
//        Person aTestPersonObj = createTestPerson();
//        dao.savePerson(aTestPersonObj);
//        List<Person> people = dao.getPeople(aTestPersonObj) ;
//        assertTrue (people.size() == 1 );
//        Person savedPerson = people.get(0) ;
//        // confirms all fields
//        assertTrue( savedPerson.getFullName().equals(aTestPersonObj.getFullName()) );
//        assertTrue( savedPerson.getDateOfBirth().equals(aTestPersonObj.getDateOfBirth()));
//        assertNotNull( savedPerson.getPhones());
//        assertTrue( savedPerson.getPhones().size() == 2);
//        assertTrue( savedPerson.getPhones().get(0).getPhoneNumber() != null );
//        assertTrue( savedPerson.getPhones().get(0).getLabel() != null ) ;
//        assertTrue( savedPerson.getPhones().get(0).getId() != 0 ) ;
//    }
//
//    @Test @Transactional @Rollback (true)
//    @SuppressWarnings("unchecked")
//    public void testUpdate() {
//        Person aTestPersonObj = createTestPerson();
//        dao.savePerson(aTestPersonObj);
//        List<Person> people = dao.getPeople(aTestPersonObj);
//        Person savedPerson = people.get(0);
//        savedPerson.setFullName("Some other person");
//        savedPerson.getPhones().get(0).setPhoneNumber("+1241353");
//        dao.updatePerson(savedPerson);
//        aTestPersonObj.setFullName("Some other person");
//        people= dao.getPeople(aTestPersonObj);
//        assertEquals(1 , people.size());
//        savedPerson = people.get(0) ;
//        assertEquals("Some other person", savedPerson.getFullName());
//        assertEquals("+1241353", savedPerson.getPhones().get(0).getPhoneNumber());
//    }
}


