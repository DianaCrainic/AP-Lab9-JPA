package repo;

import entity.Chart;

/**
 * optional
 * ChartRepository class:
 * - create method (from AbstractRepository): receives an entity and saves it into the database;
 * - findById method: returns an entity based on its primary key;
 */
public class ChartRepository extends AbstractRepository<Chart> {

    public ChartRepository() {
        super();
    }

    /*
    public void create(Chart chart) {
        entityManager.getTransaction().begin();
        entityManager.persist(chart);
        entityManager.getTransaction().commit();
    }
     */

    public Chart findById(int id) {
        Chart chart = entityManager.find(Chart.class, id);
        return chart;
    }
}
