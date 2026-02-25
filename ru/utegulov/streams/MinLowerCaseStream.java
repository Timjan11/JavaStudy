package ru.utegulov.streams;
import java.util.*;
import java.util.stream.*;

public class MinLowerCaseStream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "Hello World",
                "JAVA PROGRAMMING",
                "hello world",
                "123 TEST"

        );

        findStringWithMinLowerCaseStream(strings);
    }

    public static void findStringWithMinLowerCaseStream(List<String> strings) {

        Optional<String> result = strings.stream()
                .min(Comparator.comparingInt(s -> countLowerCase(s)));

        if (result.isPresent()) {
            String minString = result.get();
            int minCount = countLowerCase(minString);

            System.out.println("Строка с минимальным количеством строчных букв: \"" + minString + "\"");
            System.out.println("Количество строчных букв: " + minCount);

            // Выводим статистику для всех строк
            System.out.println("\nСтатистика по всем строкам:");
            strings.stream()
                    .collect(Collectors.toMap(
                            s -> s,
                            s -> countLowerCase(s)
                    ))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry ->
                            System.out.println("\"" + entry.getKey() + "\": " + entry.getValue())
                    );
        } else {
            System.out.println("Список строк пуст");
        }
    }

    public static int countLowerCase(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        return (int) str.chars()
                .filter(Character::isLowerCase)
                .count();
    }
}
