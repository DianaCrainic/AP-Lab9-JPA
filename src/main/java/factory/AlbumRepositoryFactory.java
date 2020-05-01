package factory;

import controller.AlbumController;

public class AlbumRepositoryFactory implements AbstractFactory<AlbumController> {
    @Override
    public AlbumController create(String type) {

        if (type.equals("JPA")) {
            return new AlbumController();
        }
        if (type.equals("JDBC")){
            ///
        }
        return null;
    }
}
