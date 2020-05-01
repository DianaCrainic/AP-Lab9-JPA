package factory;

public interface AbstractFactory<T> {
    public T create(String type);
}
