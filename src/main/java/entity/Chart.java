package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Chart class
 * -information about a chart
 */
@Entity
@Table(name = "charts")
public class Chart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "album_id")
    private int albumId;

    @Column(name = "profit")
    private int profit;

    public Chart(int id, int albumId, int profit) {
        this.id = id;
        this.albumId = albumId;
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", profit=" + profit +
                '}';
    }
}
