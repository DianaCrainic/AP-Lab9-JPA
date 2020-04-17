package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * PersistenceUtil class:
 * - contains a method for creating/returning an EntityManagerFactory object. I
 * - Singleton design pattern.
 */
public class PersistenceUtil {
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    public PersistenceUtil() {
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
