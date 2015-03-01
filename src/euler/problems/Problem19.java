package euler.problems;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.Callable;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 *      1 Jan 1900 was a Monday.
 *      Thirty days has September,
 *      April, June and November.
 *      All the rest have thirty-one,
 *      Saving February alone,
 *      Which has twenty-eight, rain or shine.
 *      And on leap years, twenty-nine.
 *      A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 * @author james.bogan
 */
public class Problem19 implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        // deciding to use the new date API instead of number crunching
        LocalDate endDate = LocalDate.of(2000, Month.DECEMBER, 2);
        LocalDate dateToCheck = LocalDate.of(1901, Month.JANUARY, 1);

        int numberOfSundays = 0;
        do {
            if (dateToCheck.getDayOfWeek() == DayOfWeek.SUNDAY) {
                numberOfSundays++;
            }

            dateToCheck = dateToCheck.plusMonths(1);
        } while (dateToCheck.isBefore(endDate));

        return Long.valueOf(numberOfSundays);
    }
}

