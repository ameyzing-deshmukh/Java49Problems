package org.problems.corejava.java8examples.datetime;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.IntStream;

public class DateTimeDemo {
    public static void main(String[] args) {
//        localDateTimeExample();
//
//        getLastThursday();
//        dfBtwZoneIdAndOffset();

//        zoDaTiToInstant();
//        lengthOfMonthsInYear();
//        allMondaysOfMonth(Month.MAY);
        testIfFridayThirteenth(LocalDate.of(2024, 12, 14));
    }

    private static void testIfFridayThirteenth(LocalDate dateToTest) {
        //        Write an example that tests whether a given date occurs on Friday the 13th.
        if (dateToTest.getDayOfWeek().equals(DayOfWeek.FRIDAY) && dateToTest.getDayOfMonth() == 13) {
            System.out.println("Yes date occurs on Friday the thirteenth");
        } else {
            System.out.println("It does not occur on Friday the thirteenth");
        }
    }

    private static void allMondaysOfMonth(Month monthOfChoice) {
        //         Write an example that, for a given month of the current year, lists all the Mondays in that month.
        LocalDate currentDate = LocalDate.now();//Get today's date
        Year year = Year.of(currentDate.getYear());//Get current year
        LocalDate firstDayOfMonth = year.atMonth(monthOfChoice).atDay(1);//Get first day of desired month in current year;
        LocalDate mondayOfMonth = firstDayOfMonth.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));//Shift to first Monday of that month
        Month mi = mondayOfMonth.getMonth();//Get month for first Monday
        while (monthOfChoice == mi) {//Compare if original month and month of next Monday are same
            System.out.println(mondayOfMonth);//Print the date of Monday
            mondayOfMonth = mondayOfMonth.with(TemporalAdjusters.next(DayOfWeek.MONDAY));//Shift to next Monday
            mi = mondayOfMonth.getMonth();//Get the month of next Monday
        }
    }

    private static void lengthOfMonthsInYear() {
        //Write an example that, for a given year, reports the length of each month within that year
        int yearOfChoice = 2012;
        Year year = Year.of(yearOfChoice);
        IntStream.rangeClosed(1, 12).forEach(i -> System.out.println(year.atMonth(i).lengthOfMonth()));
    }

    private static void zoDaTiToInstant() {
        //        How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
        ZonedDateTime date = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(date);

        System.out.println(date.toInstant());
    }

    private static void dfBtwZoneIdAndOffset() {
        //What is the difference between a ZoneId and a ZoneOffset?
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        System.out.println(ZoneId.systemDefault().getId());
    }

    private static void localDateTimeExample() {
        // Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
        LocalDateTime birthDate = LocalDateTime.parse("1990-01-01T07:05:10.000");
        System.out.println("Birthdate month: " + birthDate.getMonth());
    }

    private static void getLastThursday() {
        //Given a random date, how would you find the date of the previous Thursday?
        LocalDate today = LocalDate.now();
        int value = today.getDayOfWeek().getValue();
        int thursdayOffset = value - 4;

        if (thursdayOffset < 0) {
            thursdayOffset += 7;
        }

        LocalDate lastThursday = today.minusDays(thursdayOffset);
        System.out.println(lastThursday);

        LocalDate date = LocalDate.now();
        System.out.printf("The previous Thursday is: %s%n",
                date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
    }
}
