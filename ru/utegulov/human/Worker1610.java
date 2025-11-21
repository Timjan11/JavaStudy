package ru.utegulov.human;

public class Worker1610 {
    Name name;
    Department1610 department;

    public Worker1610(String firstName, String lastName) {
        this.name = new Name(firstName, lastName);
    }

    public Worker1610(String firstName, String lastName, Department1610 department) {
        this.name = new Name(firstName, lastName);
        setDepartment(department);
    }

    public boolean setDepartment(Department1610 newDepartment) {
        if (newDepartment == null) {

            if (this.department != null && this.department.getBoss() == this) {
                this.department.removeBoss();
            }
            this.department = null;
            return true;
        }

        this.department = newDepartment;

        if (newDepartment.getBoss() == this) {

            return true;
        }

        return true;
    }

    public boolean becomeBoss() {
        if (department == null) {

            return false;
        }

        return department.setBoss(this);
    }


    public boolean transferToDepartment(Department1610 newDepartment) {
        if (newDepartment == null) {
            return setDepartment(null);
        }

        if (department != null && department.getBoss() == this) {
            department.removeBoss();
        }

        this.department = newDepartment;
        return true;
    }

    public boolean transferAndBecomeBoss(Department1610 newDepartment) {
        if (newDepartment == null) {
            return false;
        }


        if (department != null && department.getBoss() == this) {
            department.removeBoss();
        }

        this.department = newDepartment;
        return newDepartment.setBoss(this);
    }

    @Override
    public String toString() {
        if (department == null) {
            return name + " (без отдела)";
        }

        if (department.getBoss() == this) {
            return name + " - начальник отдела " + department.getName();
        }

        if (department.getBoss() == null) {
            return name + " работает в отделе " + department.getName() + " (начальник не назначен)";
        }

        return name + " работает в отделе " + department.getName() + ", начальник: " + department.getBoss().name;
    }

}
