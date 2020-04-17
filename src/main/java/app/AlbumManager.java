package app;

import entity.Album;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;
import util.PersistenceUtil;

import java.util.List;

/**
 * main class AlbumManager in order to test the application
 */
public class AlbumManager {
    public static void main(String[] args) {
        ArtistRepository artistRepository = new ArtistRepository(PersistenceUtil.getEntityManager());
        AlbumRepository albumRepository = new AlbumRepository(PersistenceUtil.getEntityManager());

        Artist artist1 = new Artist(1, "Rihanna", "Barbados");
        artistRepository.create(artist1);
        Artist artist2 = artistRepository.findById(1);
        System.out.println("The artist with id=1 is:" + artist2.getName());

        Album album1 = new Album(2, "Loud", 1, 2010);
        albumRepository.create(album1);
        List<Album> albums = albumRepository.findByName("Loud");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println("The albums are: " + albums.get(i).getName());
        }


    }
}
