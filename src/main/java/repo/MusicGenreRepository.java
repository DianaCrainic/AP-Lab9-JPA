package repo;

import entity.MusicGenre;

/**
 * optional
 * ChartRepository class:
 * - create method (from AbstractRepository): receives an entity and saves it into the database;
 * - findById method: returns an entity based on its primary key;
 */
public class MusicGenreRepository extends AbstractRepository<MusicGenre> {
    public MusicGenreRepository() {
        super();
    }

    /*
    public void create(MusicGenre musicGenre) {
        entityManager.getTransaction().begin();
        entityManager.persist(musicGenre);
        entityManager.getTransaction().commit();
    }
     */

    public MusicGenre findById(int id) {
        MusicGenre musicGenre = entityManager.find(MusicGenre.class, id);
        return musicGenre;
    }

    public MusicGenre getRandomGenre() {
        return (MusicGenre) entityManager.createNamedQuery("MusicGenre.getRandomGenre")
                .setMaxResults(1).getSingleResult();
    }
}
