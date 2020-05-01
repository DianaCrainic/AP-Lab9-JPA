package repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * optional
 * A generic AbstractRepository using generics
 * in order to simplify the creation of the repository classes.
 */
public abstract class AbstractRepository<T> {
    protected EntityManager entityManager;
    protected EntityTransaction entityTransaction;

    public AbstractRepository(EntityManager entityManager, EntityTransaction entityTransaction) {
        this.entityManager = entityManager;
        this.entityTransaction = entityTransaction;
    }

    public AbstractRepository() {
    }

    public void create(T entity) {
        entityTransaction.begin();
        entityManager.persist(entity);
        entityTransaction.commit();
    }
}
