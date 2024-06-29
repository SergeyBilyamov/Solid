package com.genealogy.view;

import com.genealogy.model.Gender;
import com.genealogy.model.Person;
import com.genealogy.presenter.FamilyTreePresenter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FamilyTreeConsoleView implements FamilyTreeView {
    private Scanner scanner;

    public FamilyTreeConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showFamilyMembers(List<Person> members) {
        for (Person person : members) {
            System.out.println(person);
        }
    }

    @Override
    public void showChildren(List<Person> children) {
        for (Person child : children) {
            System.out.println(child);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Person getPersonDetails() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (MALE/FEMALE): ");
        String gender = scanner.nextLine();
        System.out.println("Введите дату рождения (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите имя родителя (если есть): ");
        String parentName = scanner.nextLine();

        return new Person(name, Gender.valueOf(gender.toUpperCase()), birthDate, parentName.isEmpty() ? null : parentName);
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public void start(FamilyTreePresenter presenter) { // Реализация метода start
        while (true) {
            System.out.println("1. Добавить члена семьи");
            System.out.println("2. Показать всех членов семьи");
            System.out.println("3. Показать детей члена семьи");
            System.out.println("4. Сортировать по имени");
            System.out.println("5. Сортировать по дате рождения");
            System.out.println("6. Сохранить семейное дерево");
            System.out.println("7. Загрузить семейное дерево");
            System.out.println("8. Выход");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    presenter.addMember();
                    break;
                case "2":
                    presenter.showAllMembers();
                    break;
                case "3":
                    presenter.showChildren();
                    break;
                case "4":
                    presenter.sortByName();
                    break;
                case "5":
                    presenter.sortByBirthDate();
                    break;
                case "6":
                    presenter.saveFamilyTree();
                    break;
                case "7":
                    presenter.loadFamilyTree();
                    break;
                case "8":
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}