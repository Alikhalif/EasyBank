package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        LocalTime lt = LocalTime.now();
        System.out.println(lt);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDate ldf = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM|yy|dd");
        System.out.println(formatter.format(ldf));

        LocalDate ldBtw = LocalDate.of(1990, 7, 22);
        LocalDate lcdNow = LocalDate.now();
        long daysBettwen = ChronoUnit.DAYS.between(ldBtw, lcdNow);
        System.out.println(daysBettwen);


        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
//        // Adding 1 week to the current date
        LocalDate nextWeek = today.plusDays(1);
        System.out.println("Next week: " + nextWeek);
//       // Subtracting 1 month from the current date
        LocalDate lastMonth = today.minusMonths(1);

        System.out.println("Last month: " + lastMonth);

        Instant currentInstant = Instant.now();
        System.out.println(currentInstant);


//        // Creating two LocalDate instances
        LocalDate date1 = LocalDate.of(2022, 9, 1);
        LocalDate date2 = LocalDate.now();

        // Calculating the period between the two dates
        Period period = Period.between(date1, date2);
        System.out.println(period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");

        // Adding the period to a date
        LocalDate datePlusPeriod = date1.plus(period);
        System.out.println("Date " + date1 + " plus period: " + datePlusPeriod);


        ZonedDateTime currentDateTime = ZonedDateTime.now();
        System.out.println("Current date and time: " + currentDateTime);


        ZoneId zonedate = ZoneId.of("Asia/Tokyo");
        System.out.println(LocalDateTime.now(zonedate));


    }
}







