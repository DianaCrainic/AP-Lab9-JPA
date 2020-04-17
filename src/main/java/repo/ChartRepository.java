package repo;

import entity.Chart;

import javax.persistence.EntityManager;


/**
 * optional
 * ChartRepository class:
 * - create method: receives an entity and saves it into the database;
 * - findById method: returns an entity based on its primary key;
 */
public class ChartRepository {

    private EntityManager entityManager;

    public ChartRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Chart chart) {
        entityManager.getTransaction().begin();
        entityManager.persist(chart);
        entityManager.getTransaction().commit();
    }

    public Chart findById(int id) {
        Chart chart = entityManager.find(Chart.class, id);
        return chart;
    }
}
