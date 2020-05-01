package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * PersistenceUtil class:
 * - contains a method for creating/returning an EntityManagerFactory object
 * - Singleton design pattern.
 */
public class PersistenceUtil {
    private static EntityManager entityManager;
    private static PersistenceUtil persistenceUtil;
    private static EntityManagerFactory entityManagerFactory;

    public PersistenceUtil() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        }
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static PersistenceUtil getInstance() {
        if (persistenceUtil == null) {
            persistenceUtil = new PersistenceUtil();
        }
        return persistenceUtil;
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
