package com.genealogy;

import com.genealogy.io.FamilyTreeFileHandler;
import com.genealogy.io.FamilyTreeFileHandlerImpl;
import com.genealogy.model.FamilyTree;
import com.genealogy.model.Person;
import com.genealogy.presenter.FamilyTreePresenter;
import com.genealogy.service.FamilyTreeService;
import com.genealogy.view.FamilyTreeConsoleView;
import com.genealogy.view.FamilyTreeView;

public class Main {
    public static void main(String[] args) {
        // Инициализация компонентов
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FamilyTreeFileHandler<FamilyTree<Person>> fileHandler = new FamilyTreeFileHandlerImpl<>();
        FamilyTreeService<Person> service = new FamilyTreeService<>(familyTree, fileHandler);
        FamilyTreeView view = new FamilyTreeConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        // Запуск приложения
        view.start(presenter);
    }
}