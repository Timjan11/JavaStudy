package ru.utegulov.human;

public class HumanWithName {
    NameConstructor name;
    HumanWithName father;

    private HumanWithName(NameConstructor name, HumanWithName father) {
        this.name = name;
        this.father = father;
    }

    public HumanWithName(String firstName) {
        this(new NameConstructor(firstName), null);
    }

    public HumanWithName(NameConstructor name) {
        this(name, null);
    }

    public HumanWithName(HumanWithName father, String firstName) {
        this(new NameConstructor(firstName), father);
    }

    public HumanWithName(HumanWithName father, NameConstructor name) {
        this(name, father);
    }

    public String getFirstName() {
        return name != null ? name.getFirstName() : null;
    }

    public String getSurName() {
        return name != null ? name.getSurName() : null;
    }
    public String getLastName() {
        if (name != null && name.getLastName() != null) {
            return name.getLastName();
        }
        HumanWithName current = father;
        while (current != null) {
            if (current.name != null && current.name.getLastName() != null) {
                return current.name.getLastName();
            }
            current = current.father;
        }
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        String firstName = getFirstName();
        String surName = getSurName();
        String lastName = getLastName();

        if (firstName != null) {
            result.append(firstName);
        }

        if (surName != null) {
            if (result.length() > 0) result.append(" ");
            result.append(surName);
        }

        if (lastName != null) {
            if (result.length() > 0) result.append(" ");
            result.append(lastName);
        }

        return result.toString();
    }
}