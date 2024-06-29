package com.genealogy.service;

import com.genealogy.io.FamilyTreeFileHandler;
import com.genealogy.model.FamilyTree;
import com.genealogy.model.Person;

import java.io.IOException;
import java.util.List;

public class FamilyTreeService<T extends Person> {
    private FamilyTree<T> familyTree;
    private FamilyTreeFileHandler<FamilyTree<T>> fileHandler;

    public FamilyTreeService(FamilyTree<T> familyTree, FamilyTreeFileHandler<FamilyTree<T>> fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void addMember(T person) {
        familyTree.addMember(person);
    }

    public List<T> getAllMembers() {
        return familyTree.getMembers();
    }

    public List<T> getChildren(String name) {
        return familyTree.getAllChildren(name);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void saveToFile(String filename) throws IOException {
        fileHandler.saveToFile(familyTree, filename);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        this.familyTree = fileHandler.loadFromFile(filename);
    }
}