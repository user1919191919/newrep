import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Creating Date objects:");
        Date today = new Date();
        System.out.println("Today: " + today.printDate());

        Date independenceDay = new Date(4, 7, 2023);
        System.out.println("Independence Day 2023: " + independenceDay.printDate());

        Date newYear = new Date(1, 1, 2024);
        System.out.println("New Year 2024: " + newYear.printDate());


        System.out.println("\nTrying to create invalid dates:");
        try {
            Date invalidDate = new Date(31, 2, 2023);
            System.out.println("This should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            Date invalidLeapYear = new Date(29, 2, 2023);
            System.out.println("This should not print");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }


        Date leapYearDate = new Date(29, 2, 2024);
        System.out.println("Leap year date: " + leapYearDate.printDate());


        System.out.println("\nUpdating a Date object:");
        Date dateToUpdate = new Date(15, 5, 2023);
        System.out.println("Before update: " + dateToUpdate.printDate());

        boolean updateSuccess = dateToUpdate.updateDate(25, 12, 2023);
        System.out.println("Update successful: " + updateSuccess);
        System.out.println("After update: " + dateToUpdate.printDate());

        boolean updateFail = dateToUpdate.updateDate(31, 4, 2023);
        System.out.println("Invalid update successful: " + updateFail);
        System.out.println("Date remains: " + dateToUpdate.printDate());


        System.out.println("\nGetting day of the week:");
        System.out.println(independenceDay.printDate() + " was a " + independenceDay.getDayOfWeek());
        System.out.println(newYear.printDate() + " was a " + newYear.getDayOfWeek());


        System.out.println("\nCalculating difference between dates:");
        long diff1 = independenceDay.calculateDifference(newYear);
        System.out.println("Days between " + independenceDay.printDate() + " and " +
                newYear.printDate() + ": " + diff1 + " days");

        long diff2 = today.calculateDifference(independenceDay);
        System.out.println("Days between today and " + independenceDay.printDate() +
                ": " + diff2 + " days");


        System.out.println("\nSorting dates:");
        List<Date> dateList = new ArrayList<>();
        dateList.add(new Date(15, 3, 2023));
        dateList.add(new Date(5, 1, 2024));
        dateList.add(new Date(10, 7, 2022));
        dateList.add(new Date(25, 12, 2023));
        dateList.add(new Date(1, 5, 2023));

        System.out.println("Before sorting:");
        for (Date date : dateList) {
            System.out.println(date.printDate());
        }

        Collections.sort(dateList);

        System.out.println("\nAfter sorting (by year, month, day):");
        for (Date date : dateList) {
            System.out.println(date.printDate());
        }
    }
}