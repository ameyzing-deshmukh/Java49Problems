package org.problems.corejava.java8examples.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

//        1. Separate odd and even numbers
//        2. separateOddEvenInMap();
//        3. countOccurances();
//        4. sortInReverse();
//        5. printMultiplesOfFive();
//        6. mergeNSortArrays();
//        7. mergeSortNDistinctArray();
//        8. Three Max & Min Numbers From The List
//        9. threeMaxNMinFromList();
//        10. sortByStringLength();
//        11. Sum & Average Of All Elements Of An Array
//        12. sumNAvgOfArrayElement();
//        13. reverseIntegerArray();
//        14. Palindrome Program In Java 8
//        15. checkPalindrome();
//        16. getLastElementOfArray();
//        17. findAgeInYears();
//        18. removeDuplicatesFromList();
//        19. frequencyOfEachElementInArray();
//        20. joinStringsWithExtraStrings();
//        21. findMaxMin();
//        22. findIfStringsAreAnagrams();
//        23. sumOfDigitInANumber();
//        24. secondLargestNumberInArray();
//        25. commonValuesBetweenTwoArrays();
//        26. reverseEachWordOfString();
//        27. sumOf10NaturalNumbers();
//        28. stringStartingWithNumber();
//        29. listDuplicateNumbers();
//        30. fibonacciSeries();
//        31. findFirstElement();
//        32. Given a String, find the first non-repeated character in it using Stream functions?
//        33. Given a String, find the first repeated character in it using Stream functions?
//        34. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
//        35. How will you get the current date and time using Java 8 Date and Time API?
//        36. Write a Java 8 program to concatenate two Streams?
//        37. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
//        38. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
//        39. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
    }


    public static void findFirstElement() {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        myList.stream()
                .findFirst()
                .ifPresent(System.out::println);

        /* or can also try below single line code */
        /* When numbers are given as Array */
        int[] arr = {};
        Arrays.stream(arr).boxed().findFirst().ifPresent(System.out::print);
    }

    private static void fibonacciSeries() {
        //print 0 1 1 2 3 5 8 13 21 34 55 89
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).map(f -> f[0]).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void listDuplicateNumbers() {
        Set<Integer> set = new HashSet<Integer>();
        Stream.of(1, 2, 3, 3, 4, 4, 5, 6, 6).filter(i -> !set.add(i)).collect(Collectors.toSet()).forEach(System.out::println);
    }

    private static void stringStartingWithNumber() {
        String a = "My name is 2Amey";
        Arrays.asList(a.split(" ")).stream().filter(i -> Character.isDigit(i.charAt(0))).forEach(System.out::println);
    }

    private static void sumOf10NaturalNumbers() {
        System.out.println(IntStream.rangeClosed(1, 10).sum());
    }

    private static void reverseEachWordOfString() {
        String a = "My name is Amey";
        System.out.println(Arrays.stream(a.split(" ")).map(s -> new StringBuffer(s).reverse()).collect(Collectors.joining(" ")));
    }

    private static void commonValuesBetweenTwoArrays() {
        Integer[] a = {1, 2, 4, 5, 8, 9, 20, 33, 4};
        Integer[] b = {1, 5, 6, 7, 4, 33};
        List<Integer> bList = List.of(b);

        List.of(a).stream().filter(i -> bList.contains(i)).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void secondLargestNumberInArray() {
        System.out.println(Arrays.asList(new Integer[]{1, 2, 3, 9, 5, 66, 65, 43, 44, 68}).stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
    }

    private static void sumOfDigitInANumber() {
        int i = 100000;
        System.out.println(Arrays.stream(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::valueOf)));
    }

    private static void findIfStringsAreAnagrams() {
        String one = "Listen";
        String two = "silent";
        one = Arrays.stream(one.split("")).map(String::toUpperCase).sorted(Comparator.naturalOrder()).collect(Collectors.joining());
        two = Arrays.stream(two.split("")).map(String::toUpperCase).sorted(Comparator.naturalOrder()).collect(Collectors.joining());
        System.out.println(one.equals(two));
    }

    private static void findMaxMin() {
        System.out.println(Stream.of(1, 2, 3).min(Comparator.naturalOrder()).get());
        System.out.println(Stream.of(1, 2, 3).max(Comparator.naturalOrder()).get());
    }

    private static void joinStringsWithExtraStrings() {
        System.out.println(Stream.of("aa", "ss", "dd").collect(Collectors.joining("-", "prefix", "suffix")));
    }

    private static void frequencyOfEachElementInArray() {
        Stream.of(1, 2, 2, 2, 3, 4, 5, 3, 8, 8, 7, 5, 5).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((i, k) -> System.out.println(i + " " + k));
    }

    private static void removeDuplicatesFromList() {
        List.of(1, 2, 3, 4, 23, 4, 2, 5, 5, 55, 0).stream().distinct().forEach(System.out::println);//Use collect() method
    }

    private static void findAgeInYears() {
        LocalDate birthday = LocalDate.of(1990, 10, 2);
        LocalDate today = LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(birthday, today));
    }

    private static void getLastElementOfArray() {
        List listOfStrings = new ArrayList();
        listOfStrings.add("aa");
        listOfStrings.add("bb");
        System.out.println(listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().get());
    }


    private static void checkPalindrome() {
        String str = "ajhklkhj";
        System.out.println(IntStream.rangeClosed(0, str.length() / 2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - 1 - i)));
    }

    private static void reverseIntegerArray() {
        int[] a = new int[]{2, 3, 4, 5, 6};
        IntStream.generate(() -> (int) (Math.random() * 10)).limit(5).forEach(System.out::println);
        IntStream.rangeClosed(1, a.length).map(i -> a[a.length - i]).forEach(System.out::println);
        IntStream.rangeClosed(1, a.length).forEach(System.out::println);
    }


    private static void sumNAvgOfArrayElement() {
//        IntStream b = IntStream.of(1, 2, 3);
        int[] a = new int[]{2, 3, 4, 5, 6};
        int sum = IntStream.of(a).sum();
        double average = IntStream.of(a).average().getAsDouble();
        System.out.println("Sum is: " + sum + " and average is: " + average);
    }

    String concatFLName(Employee a) {

        return a.name + a.lName;
    }

    private static void sortByStringLength() {
        StreamDemo sd = new StreamDemo();
        Comparator<Employee> c = Comparator.comparing(sd::concatFLName);
        Stream.of(new Employee("Amey", "Deshmukh", 2), new Employee("Ram", "Deshmukh", 2), new Employee("Vijay", "Deshmukh", 2), new Employee("Ra", "Deshmukh", 2)).map(sd::concatFLName).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    private static void threeMaxNMinFromList() {
        Stream.of(2, 4, 2, 3, 4, 5, 666, 76, 88, 34).sorted().distinct().limit(3).forEach(System.out::println);
        Stream.of(2, 4, 9, 3, 4, 5, 666, 76, 88, 34).sorted(Comparator.reverseOrder()).distinct().limit(3).forEach(System.out::println);
    }

    private static void mergeSortNDistinctArray() {
        int[] a = new int[]{33, 33, 6, 22};
        int[] b = new int[]{23, 56, 7, 88};
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().forEach(System.out::println);
    }

    private static void mergeNSortArrays() {
        int[] a = new int[]{7, 1, 2, 66, 3, 43};
        int[] b = new int[]{33, 54, 4, 5, 6, 74, 22};
        int[] mergedArray = IntStream.concat((IntStream) Arrays.stream(a), (IntStream) Arrays.stream(b)).sorted().toArray();
        Arrays.stream(mergedArray).forEach(System.out::println);
    }

    private static void printMultiplesOfFive() {
        Random r = new Random();

        IntStream intStream = r.ints(10);
//        intStream.filter(n -> n % 5 == 0).forEach(System.out::println);
        Stream.of(1, 5, 55, 25, 67, 78, 89).filter(n -> n % 5 == 0).forEach(System.out::println);
    }

    private static void sortInReverse() {
        Random r = new Random();
        Stream<Integer> integerStream = Stream.iterate(1, n -> Math.abs(r.nextInt())).limit(4);
        integerStream.sorted((i, j) -> j.compareTo(i)).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void countOccurances() {
        String test = "IlovemycountryIndia";
        test.chars().mapToObj(c -> (char) c).map(c -> Character.toLowerCase(c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((i, j) -> System.out.println(i + " " + j));
    }

    private static void separateOddEvenInMap() {
        Stream<Integer> intStream = Stream.iterate(1, n -> n + 1).limit(50);

        Map<Boolean, List<Integer>> segregatedList = intStream.collect(Collectors.partitioningBy(i -> i % 2 == 0));

        segregatedList.forEach((i, j) -> System.out.println(i + " " + j));
    }
}
