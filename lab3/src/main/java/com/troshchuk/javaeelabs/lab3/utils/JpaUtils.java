package com.troshchuk.javaeelabs.lab3.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
    private static EntityManager entityManager;
    private static final String PERSISTENCE_UNIT = "PERSISTENCE_UNIT";

    public static EntityManager getEntityManager() {
        if (entityManager != null) {
            return entityManager;
        } else {
            synchronized (JpaUtils.class) {
                if (entityManager == null) {
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
                    entityManager = emf.createEntityManager();
                }
                return entityManager;
            }
        }
    }
}
