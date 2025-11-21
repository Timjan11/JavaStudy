package ru.utegulov.human;

public class Department1610 {
    private String nameOfDepartment;
    private Worker1610 boss;

    public Department1610(String name) {
        this.nameOfDepartment = name;
    }

    public String getName() {
        return nameOfDepartment != null ? nameOfDepartment : "";
    }

    public Worker1610 getBoss() {
        return boss;
    }

    public boolean setBoss(Worker1610 newBoss) {
        if (newBoss == null) {
            this.boss = null;
            return true;
        }


        if (newBoss.department != this) {
            newBoss.department = this;
        }

        this.boss = newBoss;
        return true;
    }


    public void removeBoss() {
        this.boss = null;
    }

    @Override
    public String toString() {
        if (nameOfDepartment == null || nameOfDepartment.isEmpty()) {
            return boss != null ? "Отдел начальника " + boss.name : "Безымянный отдел";
        }
        if (boss == null) {
            return nameOfDepartment;
        }
        return nameOfDepartment + " (начальник: " + boss.name + ")";
    }
}
