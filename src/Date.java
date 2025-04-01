import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;


    private static final String[] MONTH_NAMES = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };


    private static final String[] DAY_NAMES = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };


    private static final int[] DAYS_IN_MONTH = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };


    public Date() {

        Calendar calendar = Calendar.getInstance();
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.year = calendar.get(Calendar.YEAR);
    }

    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
    }


    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isValidDate(int day, int month, int year) {

        if (year < 1) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }


        int maxDays = DAYS_IN_MONTH[month - 1];


        if (month == 2 && isLeapYear(year)) {
            maxDays = 29;
        }

        return day >= 1 && day <= maxDays;
    }


    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    public boolean updateDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
            return true;
        }
        return false;
    }


    public String getDayOfWeek() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return DAY_NAMES[dayOfWeek - 1];
    }


    public long calculateDifference(Date otherDate) {
        Calendar calendar1 = new GregorianCalendar(this.year, this.month - 1, this.day);
        Calendar calendar2 = new GregorianCalendar(
                otherDate.year, otherDate.month - 1, otherDate.day);

        long diffMillis = Math.abs(calendar1.getTimeInMillis() - calendar2.getTimeInMillis());
        return diffMillis / (24 * 60 * 60 * 1000);
    }

    public String printDate() {
        return MONTH_NAMES[month - 1] + " " + day + ", " + year;
    }


    @Override
    public int compareTo(Date other) {

        int yearComparison = Integer.compare(this.year, other.year);
        if (yearComparison != 0) {
            return yearComparison;
        }

        int monthComparison = Integer.compare(this.month, other.month);
        if (monthComparison != 0) {
            return monthComparison;
        }


        return Integer.compare(this.day, other.day);
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}