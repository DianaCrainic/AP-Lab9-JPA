package factory;

import entity.Album;

public interface AlbumRepository {
    Album create(Album album);
}
