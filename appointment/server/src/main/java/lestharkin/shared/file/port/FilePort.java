package lestharkin.shared.file.port;

public interface FilePort<T> {

    T getObject(String pathFile, Class<T> classOfT);

    T[] getObjects(String pathFile, Class<T[]> classOfT);

    Boolean writeObject(String pathFile, T object);

    Boolean writeObjects(String pathFile, T[] objects);

}