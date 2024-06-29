package com.genealogy.io;

import java.io.*;

public class FamilyTreeFileHandlerImpl<T> implements FamilyTreeFileHandler<T> {

    @Override
    public void saveToFile(T tree, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tree);
        }
    }

    @Override
    public T loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (T) ois.readObject();
        }
    }
}


