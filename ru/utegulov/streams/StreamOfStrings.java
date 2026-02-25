package ru.utegulov.streams;

import java.util.*;
import java.util.stream.Collectors;

public class  StreamOfStrings{
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "Hello world",
                "Java",
                "test!"
        );

        Map<Character, Long> letterCount = countLettersStream(strings);


        letterCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static Map<Character, Long> countLettersStream(List<String> strings) {
        return strings.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(
                        c -> c,
                        Collectors.counting()
                ));
    }
}