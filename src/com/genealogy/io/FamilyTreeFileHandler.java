package com.genealogy.io;

import java.io.IOException;

public interface FamilyTreeFileHandler<T> {
    void saveToFile(T tree, String filename) throws IOException;
    T loadFromFile(String filename) throws IOException, ClassNotFoundException;
}




