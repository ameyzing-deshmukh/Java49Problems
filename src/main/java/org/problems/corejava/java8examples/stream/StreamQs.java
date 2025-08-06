package org.problems.corejava.java8examples.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamQs {

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

    public static void main(String[] args) {
//        separateOddEvenInLists();
//        returnDomainFromEmailId("Vijayi@bharat.com");
        returnStringCount(List.of("yy","ii","yy","ll"));
    }

    private static void separateOddEvenInLists() {
        List<Integer> mix = List.of(1,2,3,4,5,6,77,87,88);
        Map<Boolean, List<Integer>> oddEvenMap = mix.stream().collect(Collectors.partitioningBy(i->(i%2==0)));
        oddEvenMap.forEach((b, i)->System.out.println(b+" "+i));
    }

    private static void returnDomainFromEmailId(String emailId){
        System.out.println(emailId);
        if(emailId.contains("@")) {
            System.out.println(emailId.split("@")[1]);
        }
        else{
            System.out.println("emailId is invalid");
        }
    }

    private static void  returnStringCount(List<String> strList){
        strList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((k,v)-> System.out.println(k+"-"+v));
    }
    

}
