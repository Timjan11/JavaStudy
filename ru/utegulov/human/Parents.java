package ru.utegulov.human;

public class Parents {
    public NameConstructor name;
    private HumanWithName father;

    private Parents(NameConstructor name, HumanWithName father) {
        this.name = name;
        this.father = father;
    }

    public HumanWithName getFather() {
        return father;
    }

    public NameConstructor getName() {
        return name;
    }

    public Parents(String firstName) {
        this(new NameConstructor(firstName), null);
    }

    public Parents(NameConstructor name) {
        this(name, null);
    }

    public Parents(HumanWithName father, String firstName) {
        this(new NameConstructor(firstName), father);
    }

    public Parents(HumanWithName father, NameConstructor name) {
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
