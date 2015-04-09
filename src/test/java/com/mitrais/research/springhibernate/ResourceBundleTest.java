package com.mitrais.research.springhibernate;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Locale;

/**
 * @author Gama Ogi Prayogo
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-service.xml")
public class ResourceBundleTest {
//    private Logger log = Logger.getLogger(ResourceBundleTest.class);
//
//    @Autowired
//    private ResourceBundleMessageSource messageSource;
//
//    @Test
//    public void getResourceBundleDefaultLocale() {
//        String message = messageSource.getMessage("test", null, Locale.getDefault());
//        log.debug("Using locale=" + Locale.getDefault());
//        log.debug(message);
//    }
//
//    @Test
//    public void getResourceBundleSpecificLocale() {
//        Locale idLocale = new Locale("id_ID");
//        String message = messageSource.getMessage("test", null, idLocale);
//        log.debug("Using locale=" + idLocale);
//        log.debug(message);
//    }
}
