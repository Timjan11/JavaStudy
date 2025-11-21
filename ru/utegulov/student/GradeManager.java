package ru.utegulov.student;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class GradeManager {

    public static String addRandomGradesToAll(List<Student> students) {
        if (students == null || students.isEmpty()) {
            return "Список студентов пуст";
        }

        Random random = new Random();
        List<Integer> gradesToAdd = new ArrayList<>();


        for (int i = 0; i < students.size(); i++) {
            int randomGrade = random.nextInt(10) + 1; // от 1 до 10
            gradesToAdd.add(randomGrade);
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            int grade = gradesToAdd.get(i);

            if (!student.addGrade(grade)) {
                return "Не удалось добавить оценку " + grade +
                        " студенту " + student.getName() +
                        " (позиция " + i + ")";
            }
        }


        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            int grade = gradesToAdd.get(i);
            student.addGrade(grade);
        }

        return "Все оценки успешно добавлены";
    }
}
