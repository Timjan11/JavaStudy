package ru.utegulov.student;

import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private List<Integer> grades;
    private Deque<StudentMemento> history = new ArrayDeque<>();

    // Исключение
    public static class NotCorrectGradeException extends RuntimeException {
        public NotCorrectGradeException(String message) {
            super(message);
        }
    }

    // Класс-снимок для хранения состояния
    private static class StudentMemento {
        private final String name;
        private final List<Integer> grades;

        public StudentMemento(String name, List<Integer> grades) {
            this.name = name;
            this.grades = new ArrayList<>(grades); // создаем копию
        }

        public String getName() {
            return name;
        }

        public List<Integer> getGrades() {
            return new ArrayList<>(grades); // возвращаем копию
        }
    }

    public Student(String name, int... grades) {
        this.name = name;
        this.grades = new ArrayList<>();

        if (grades == null) {
            throw new NotCorrectGradeException("Оценок нет");
        }

        for (int grade : grades) {
            if (grade < 2 || grade > 5) {
                throw new NotCorrectGradeException("Не корректная оценка у студента " + name);
            }
            this.grades.add(grade);
        }

        // Сохраняем начальное состояние
        saveState();
    }

    // Метод сохранения состояния
    private void saveState() {
        history.push(new StudentMemento(name, grades));
    }

    // Метод отмены последнего действия
    public boolean cancelLastAction() {
        if (history.size() <= 1) {
            return false; // Нечего отменять, уже в начальном состоянии
        }

        // Удаляем текущее состояние
        history.pop();

        // Восстанавливаем предыдущее состояние
        StudentMemento previous = history.peek();
        this.name = previous.getName();
        this.grades = previous.getGrades();

        return true;
    }

    // Изменение имени с сохранением состояния
    public void setName(String newName) {
        saveState();
        this.name = newName;
    }

    // Добавление оценки с сохранением состояния
    public boolean addGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new NotCorrectGradeException("Не корректная оценка: " + grade);
        }

        saveState();
        grades.add(grade);
        return false;
    }

    // Удаление последней оценки
    public void removeLastGrade() {
        if (grades.isEmpty()) {
            throw new IllegalStateException("Нет оценок для удаления");
        }

        saveState();
        grades.remove(grades.size() - 1);
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        int[] result = new int[grades.size()];
        for (int i = 0; i < grades.size(); i++) {
            result[i] = grades.get(i);
        }
        return result;
    }

    public List<Integer> getGradesList() {
        return new ArrayList<>(grades);
    }

    public double getAVG() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public int getTotalActions() {
        return history.size() - 1; // Минус начальное состояние
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Student student = (Student) obj;
        return Objects.equals(this.name, student.name) &&
                this.getAVG() == student.getAVG();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getAVG());
    }

    @Override
    public String toString() {
        if (grades.isEmpty()) {
            return "Студент " + name + " без оценок";
        } else {
            StringBuilder res = new StringBuilder("Студент " + name + " с оценками: ");
            for (int i = 0; i < grades.size(); i++) {
                res.append(grades.get(i));
                if (i < grades.size() - 1) {
                    res.append(",");
                }
            }
            return res.toString();
        }
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.getAVG(), student.getAVG());
    }
}