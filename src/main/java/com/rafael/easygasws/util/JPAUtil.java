package com.rafael.easygasws.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rafael Carlos Oliveira <rafaellcarloss@hotmail.com>
 * @date 09/11/2017
 */
public class JPAUtil {

    private EntityManagerFactory factory;

    private static JPAUtil instance;

    private JPAUtil() {
        this.factory = Persistence.createEntityManagerFactory("EasyGasPU");
    }

    public static synchronized JPAUtil getInstance() {
        if (instance == null) {
            instance = new JPAUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
