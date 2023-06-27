package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pair<String, Integer>> nameAgePairs = new ArrayList<>();
        nameAgePairs.add(new Pair<>("Alice", 25));
        nameAgePairs.add(new Pair<>("Bob", 30));
        nameAgePairs.add(new Pair<>("Charlie", 35));

        List<Person> persons = nameAgePairs.stream()
                .map(Main::createPerson)
                .collect(Collectors.toList());

        System.out.println("The number of person:  "+persons.size()); // Output: 3
    }

    private static Person createPerson(Pair<String, Integer> pair) {
        String name = pair.getName();
        int age = pair.getAge();
        return new Person(name, age);
    }
}