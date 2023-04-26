package lestharkin.shared.file.json.adapter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lestharkin.shared.file.port.FilePort;

public class FileJsonAdapter<T> implements FilePort<T> {
    private static FileJsonAdapter<?> instance;
    private Object fileWriterLock;

    private FileJsonAdapter() {
        this.fileWriterLock = new Object();
    }

    @SuppressWarnings("unchecked")
    public static synchronized <T> FileJsonAdapter<T> getInstance() {
        if (instance == null) {
            instance = new FileJsonAdapter<>();
        }
        return (FileJsonAdapter<T>) instance;
    }

    @Override
    public T getObject(String pathFile, Class<T> classOfT) {
        T object = null;
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            object = gson.fromJson(bufferedReader, classOfT);
        } catch (FileNotFoundException | RuntimeException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return object;
    }

    @Override
    public T[] getObjects(String pathFile, Class<T[]> classOfT) {
        T[] objArray = null;
        try {
            Gson gson = new GsonBuilder().create();
            // BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile, StandardCharsets.UTF_8));            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            objArray = gson.fromJson(bufferedReader, classOfT);
        } catch (RuntimeException | IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objArray;
    }

    @Override
    public Boolean writeObject(String pathFile, T object) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                gson.toJson(object, writer);
            }
            successful = true;
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }

    @Override
    public Boolean writeObjects(String pathFile, T[] objects) {        
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                gson.toJson(objects, writer);
            }
            successful = true;
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }
}