package com.genealogy.presenter;

import com.genealogy.model.Person;
import com.genealogy.service.FamilyTreeService;
import com.genealogy.view.FamilyTreeView;

import java.io.IOException;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeService<Person> service;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService<Person> service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
    }

    public void addMember() {
        Person person = view.getPersonDetails();
        service.addMember(person);
        view.showMessage("Член семьи добавлен: " + person.getName());
    }

    public void showAllMembers() {
        List<Person> members = service.getAllMembers();
        if (members != null && !members.isEmpty()) {
            view.showFamilyMembers(members);
        } else {
            view.showMessage("В семейном дереве нет членов.");
        }
    }

    public void showChildren() {
        String name = view.getUserInput("Введите имя родителя: ");
        List<Person> children = service.getChildren(name);
        if (children != null && !children.isEmpty()) {
            view.showChildren(children);
        } else {
            view.showMessage(name + " не имеет детей или не найден в дереве.");
        }
    }

    public void sortByName() {
        service.sortByName();
        showAllMembers();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        showAllMembers();
    }

    public void saveFamilyTree() {
        String filename = view.getUserInput("Введите имя файла для сохранения: ");
        try {
            service.saveToFile(filename);
            view.showMessage("Семейное дерево сохранено в файл: " + filename);
        } catch (IOException e) {
            view.showMessage("Ошибка при сохранении семейного дерева: " + e.getMessage());
        }
    }

    public void loadFamilyTree() {
        String filename = view.getUserInput("Введите имя файла для загрузки: ");
        try {
            service.loadFromFile(filename);
            view.showMessage("Семейное дерево загружено из файла: " + filename);
            showAllMembers();
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage("Ошибка при загрузке семейного дерева: " + e.getMessage());
        }
    }
}