package com.genealogy.view;

import com.genealogy.model.Person;
import com.genealogy.presenter.FamilyTreePresenter;

import java.util.List;

public interface FamilyTreeView {
    void showFamilyMembers(List<Person> members);
    void showChildren(List<Person> children);
    void showMessage(String message);
    Person getPersonDetails();
    String getUserInput(String prompt);
    void start(FamilyTreePresenter presenter); // Добавлено
}