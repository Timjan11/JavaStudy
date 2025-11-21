package ru.utegulov.connection;
import java.util.List;
import java.util.ArrayList;

public class StringConverter {
    public double divideFirstNumberByOthers(List<String> strings) {

        List<Double> numbers = new ArrayList<>();

        for (String str : strings) {
            try {
                double number = Double.parseDouble(str);
                numbers.add(number);
            } catch (NumberFormatException e) {

                System.out.println("Игнорируем нечисловую строку: " + str);
            }
        }

        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Недостаточно чисел для деления. Найдено: " + numbers.size());
        }

        double firstNumber = numbers.get(0);
        double result = firstNumber;

        for (int i = 1; i < numbers.size(); i++) {
            double divisor = numbers.get(i);
            if (divisor == 0) {
                throw new ArithmeticException("Деление на ноль. Делитель на позиции " + i + " равен 0");
            }
            result /= divisor;
        }

        return result;
    }
}
