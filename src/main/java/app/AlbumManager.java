package app;

import com.github.javafaker.Faker;
import controller.ArtistController;
import entity.Album;
import entity.Artist;
import entity.MusicGenre;
import repo.AlbumRepository;
import repo.ArtistRepository;
import repo.MusicGenreRepository;
import util.PersistenceUtil;

import java.util.List;
import java.util.Random;

/**
 * main class AlbumManager in order to test the application
 * - insertGeneratedAlbums method - generate fake data in order to populate the database
 *   with a large number of albums.
 */
public class AlbumManager {
    private static int numberOfRows = 100;
    private ArtistRepository artistRepository = new ArtistRepository();
    private AlbumRepository albumRepository = new AlbumRepository();
    private MusicGenreRepository musicGenreRepository = new MusicGenreRepository();


    private void insertGeneratedAlbums(int numberOfRows) {
        Faker faker = new Faker();
        Random random = new Random();
        int i = 0;
        while (i < numberOfRows) {
            String albumName = faker.funnyName().name();
            MusicGenre musicGenre = musicGenreRepository.getRandomGenre();
            int year = random.nextInt(50) + 1970;
            Album album = new Album(albumName, musicGenre, year);
            albumRepository.create(album);
            i++;
        }
    }


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

        AlbumManager albumManager = new AlbumManager();
        albumManager.insertGeneratedAlbums(numberOfRows);
    }
}
