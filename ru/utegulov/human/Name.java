package ru.utegulov.human;

public class Name {
    String lastName;
    String firstName;
    String surName;

    public Name(String lastName, String firstName, String surName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.surName = surName;
    }

    public Name(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public Name(String lastName) {
        this(lastName, null, null);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null) {
            sb.append(lastName);
        }

        if (firstName != null) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(firstName);
        }

        if (surName != null) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(surName);
        }

        return sb.toString();
    }
}