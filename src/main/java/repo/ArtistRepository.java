package repo;

import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * ArtistRepository class:
 * - create method (from AbstractRepository): receives an entity and saves it into the database;
 * - findById method: returns an entity based on its primary key;
 * - findByName method: returns a list of entities that match a given name pattern.
 * Use a named query in order to implement this method.
 */
public class ArtistRepository extends AbstractRepository<Artist> {

    public ArtistRepository(EntityManager entityManager) {
        super();
    }

    public ArtistRepository() {

    }
    /*
    public void create (Artist artist){
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }
    */


    public Artist findById(int id) {
        Artist artist = entityManager.find(Artist.class, id);
        return artist;
    }

    public List<Artist> findByName(String name) {
        String sql = "SELECT a FROM artists a WHERE a.name LIKE :artistName";
        Query query = entityManager.createQuery(sql).setParameter("artistName", name)
                .setMaxResults(5);
        return query.getResultList();
    }
}
