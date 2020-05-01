package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Album class
 * -information about an album
 */
@Entity
@Table(name = "albums")
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "artist_id")
    private int artistId;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "genre_id")
    @ManyToOne
    private MusicGenre musicGenre;

    @ManyToOne
    private Artist artist;

    public Album(int id, String name, int artistId, int releaseYear) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }

    public Album(int id, String name, int artistId, int releaseYear, MusicGenre musicGenre) {
        this.id = id;
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
        this.musicGenre = musicGenre;
    }

    public Album(String name, MusicGenre musicGenre, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.musicGenre = musicGenre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        if (artist != null) {
            return name + " - " + artist.getName() + " (" + releaseYear + ")";
        }
        return name + " - " + artistId + " (" + releaseYear + ")";
    }

}
