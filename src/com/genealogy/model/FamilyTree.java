package com.genealogy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T person) {
        members.add(person);
    }

    public List<T> getMembers() {
        return members;
    }

    public List<T> getAllChildren(String parentName) {
        List<T> children = new ArrayList<>();
        for (T person : members) {
            if (person.getParentName() != null && person.getParentName().equals(parentName)) {
                children.add(person);
            }
        }
        return children;
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(members, Comparator.comparing(Person::getBirthDate));
    }
}