package algorithm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatesInArray {
    public static void main(String[] args) {
        int[] intArray = {1, 4, 4, 1, 5, 7, 8, 9, 7};
        System.out.println("Any Duplicates present?::: " + isDuplicatesPresent(intArray));
        getDuplicates(intArray);

        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java"};

        System.out.println(getMapDuplicate(names));
        System.out.println(getMapOfDuplicate(names));
    }

    public static boolean isDuplicatesPresent(int[] arrayToCheck) {
        Set<Integer> uniqueSet = new HashSet<Integer>();
        for (Integer o : arrayToCheck) {
            if (uniqueSet.contains(o)) return true;
            uniqueSet.add(o);
        }
        return false;
    }

    public static void getDuplicates(int[] arrayToCheck) {
        Map<Integer, Integer> mapOfDuplicates = new HashMap<>();
        for (Integer element : arrayToCheck) {
            mapOfDuplicates.put(element,
                    mapOfDuplicates.containsKey(element) ? mapOfDuplicates.get(element) + 1 : 0);
        }

        //Retain the duplicates in map and remove the unique elements
        mapOfDuplicates.entrySet().removeIf(entry -> entry.getValue() == 0);
        if (mapOfDuplicates.size() > 0) {
            System.out.print("The Duplicates are:: ");
            for (Integer s1 : mapOfDuplicates.keySet()) {
                System.out.print(s1 + " ");
            }
            System.out.println(" ");
        }
    }

    private static Map<String, Integer> getMapDuplicate(String[] args) {
        System.out.println("Duplicate elements from array using hash table");
        Map<String, Integer> nameAndCount = new HashMap<>();
        // build hash table with count
        for (String name : args) {
            Integer count = nameAndCount.get(name);
            if (count == null) {
                nameAndCount.put(name, 1);
            } else {
                nameAndCount.put(name, ++count);
            }
        }
        return nameAndCount;
    }

    private static Map<String, Long> getMapOfDuplicate(String[] args) {
        return Arrays.stream(args)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Map<Integer, Long> getMapOfDuplicate(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
