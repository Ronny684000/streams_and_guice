package streamtask.tests;

import streamtask.models.FamilyExpand;
import streamtask.models.PersonExpand;
import utils.JsonConsumer;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTestClass {

    private FamilyExpand family = JsonConsumer.getFamily("family.json");
    private List<Integer> familyAges = getFamilyAges();

    public FamilyTestClass() {}

    private List<Integer> getFamilyAges() {
        return family.getFamilyMembers().stream()
                .map(PersonExpand::getAge)
                .collect(Collectors.toList());
    }

    public void test1() {
        family.getFamilyMembers().stream()
                .sorted((member1, member2) -> member2.getAge() - member1.getAge())
                .forEach(System.out::println);
    }

    public void test2(int way) {
        switch (way) {
            case 1 -> {
                familyAges.stream()
                        .filter(age -> Collections.frequency(familyAges, age) > 1)
                        .distinct()
                        .forEach(System.out::println);
            }
            case 2 -> {
                var hashSet = new HashSet<Integer>();
                familyAges.stream()
                        .filter(age -> !hashSet.add(age))
                        .forEach(System.out::println);
            }
        }
    }

    public void test3() {
        familyAges.stream()
                .filter(age -> Collections.frequency(familyAges, age) > 1)
                .distinct()
                .collect(Collectors.toMap(age -> age, age -> Collections.frequency(familyAges, age)))
                .forEach((age, freq) -> System.out.println(age + ": " + freq + " times"));
    }

    public void test4() {
        familyAges.stream()
                .sorted(Comparator.comparingInt(member -> member))
                .filter(age -> Collections.frequency(familyAges, age) == 1)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        FamilyTestClass familyTestClass = new FamilyTestClass();
        familyTestClass.test1();
        familyTestClass.test2(2);
        familyTestClass.test3();
        familyTestClass.test4();
    }
}
