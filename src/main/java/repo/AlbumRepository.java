package repo;

import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * AlbumRepository class:
 * - create method (from AbstractRepository): receives an entity and saves it into the database;
 * - findById method: returns an entity based on its primary key;
 * - findByName method: returns a list of entities that match a given name pattern.
 * Use a named query in order to implement this method.
 * <p>
 * This class also has findByArtist method, that returns the list of albums
 * of a given artist. Use a named query in order to implement this method.
 */
public class AlbumRepository extends AbstractRepository<Album> {

    public AlbumRepository(EntityManager entityManager) {
        super();
    }

    public AlbumRepository() {

    }
    /*
    public void create(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }
    */

    public Album findById(int id) {
        Album album = entityManager.find(Album.class, id);
        return album;
    }

    public List<Album> findByName(String name) {
        String sql = "SELECT a FROM albums a WHERE a.name LIKE :albumName";
        Query query = entityManager.createQuery(sql).setParameter("albumName", name)
                .setMaxResults(10);
        return query.getResultList();
    }

    public List<Album> findByArtist(Artist artist) {
        String sql = "SELECT a FROM albums a WHERE a.artist_id = :personId";
        Query query = entityManager.createQuery(sql).setParameter("personId", artist.getId())
                .setMaxResults(5);
        return query.getResultList();
    }

}
