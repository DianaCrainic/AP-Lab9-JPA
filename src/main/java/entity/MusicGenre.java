package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * MusicGenre class
 * -information about a genre
 */
public class MusicGenre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    private List<Album> albumList = new ArrayList<>();

    public MusicGenre(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
