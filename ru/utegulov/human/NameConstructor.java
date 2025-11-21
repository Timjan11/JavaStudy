package ru.utegulov.human;

public class NameConstructor
{
    String firstName;
    String lastName;
    String surName;

    public NameConstructor(String firstName) {
        this.firstName = firstName;
    }


    public NameConstructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public NameConstructor(String firstName, String lastName, String surName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
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