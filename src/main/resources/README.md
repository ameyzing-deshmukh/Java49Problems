Solve these problems

//            1	Separate odd and even numbers into two lists - Return a Map<String, List<Integer>> with keys 'odd' and 'even'.
//            2	Return domain from email ID.
//            3	Return Map<String, Integer> with frequency count of each string.
//            4	Return list sorted in descending order.
//            5	Print all elements that are divisible by 5.
//            6	Merge two arrays and return a sorted array.
//            7	Merge arrays, remove duplicates, and return sorted list.
//            8	Return three largest and three smallest unique values.
//            9	Sort list based on string length.
//            10	Return sum and average of all elements.
//            11	Return reversed array.
//            12	Return last element (handle empty array).
//            13	Return max and min values.
//            14	Return second largest unique number.
//            15	Return list of common elements.
//            16	Check if a string is a palindrome using streams.
//            17	Remove duplicates using stream distinct().
//            18	Count frequency using Collectors.groupingBy().
//            19	Join strings with delimiter, prefix, suffix.
//            20	Return true if s1 and s2 are anagrams.
//            21	Return Map<id, name> using stream and handle duplicate keys.
//            22	Filter strings starting with a digit.
//            23	Reverse each word in the sentence individually.
//            24	Return the first element using stream().findFirst().
//            25	Return first non-repeating character using stream.
//            26	Return first repeating character using stream.
//            27	Return true if any element is repeated.
//            28	Return current system date and time using Java 8 Date/Time API.
//            29	Merge and return two streams.
//            30	Sort array and return stream.
//            31	If list is present, iterate and print each element.
//            32	Return sum of digits using loop or recursion.
//            33	Return sum of first 10 natural numbers.
//            34	Return count of vowels and consonants.
//            35	Return list of duplicated numbers.
//            36	Return string with only alphanumeric characters.
//            37	Return true if number is prime.
//            38	Return reversed string using recursion.
//            39	Return random number in given range.
//            40	Return number of digits in input.
//            41	Return greatest common divisor.
//            42	Return least common multiple.
//            43	Sort by name, then by age.
//            44	Convert list to comma-separated string.
//            45	Convert comma-separated string to list.
//            46	Return flat list using flatMap().
//            47	Return filtered list.
//            48	Convert one type of list to another.
//            49	Use custom collector to group or aggregate.
//            50	Return TreeMap or use stream to sort by keys.
//            51	Return LinkedHashMap sorted by values.
//            52	Create a map with custom logic for key/value.
//            53	Count each character’s frequency.
//            54	Use parallelStream() for processing.
//            55	Sort using comparator lambda.
//            56	Return top 5 highest values.
//            57	Return 2nd most frequent character.
//            58	Return age from DOB.
//            59	Return true if valid format using regex.
//            60	Return true if string is a valid number.
//            61	Convert and validate date input.
//            62	Return formatted HH:MM:SS.
//            63	Convert list to array and vice versa.
//            64	Return first n Fibonacci numbers.
//            65	Convert enum values to list.
//            66	Convert a CSV string like 'a:1,b:2' to Map.
//            67	Return Map<String, Integer> of word frequencies.
//            68	Implement a switch-based CLI calculator.
//            69	Return randomly shuffled list.
//            70



        /* or can also try below single line code */
    /* When numbers are given as Array */
    /*
    public static void findFirstElement() {
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        myList.stream()
                .findFirst()
                .ifPresent(System.out::println);

/* int[] arr = {};
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
*/
