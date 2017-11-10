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

    private static final String PERSISTENCE_UNIT = "EasyGasPU";
    private static final ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();
    private static EntityManagerFactory entityManagerFactory;

    private JPAUtil() {
    }

    public static ThreadLocal<EntityManager> getThreadEntityManager() {
        return threadEntityManager;
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory
                    = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        EntityManager entityManager = threadEntityManager.get();
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
            JPAUtil.threadEntityManager.set(entityManager);
        }

        return entityManager;
    }

    public static void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}
