package com.github.inchestnov.generatorstarter.utils;

import java.util.Calendar;
import java.util.Date;

import static com.github.inchestnov.generatorstarter.utils.CommonRandom.getRandomLongBetween;
import static com.github.inchestnov.generatorstarter.utils.Preconditions.checkNotNull;

public class DateRandom {

    public static Date getRandomDateInYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startDateOfYear = calendar.getTime();

        calendar.add(Calendar.YEAR, 1);
        Date endDateOfYear = calendar.getTime();

        return getRandomDateBetween(startDateOfYear, endDateOfYear);
    }

    public static Date getRandomDateInMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDateOfMonth = calendar.getTime();

        calendar.add(Calendar.MONTH, 1);
        Date endDateOfMonth = calendar.getTime();

        return getRandomDateBetween(startDateOfMonth, endDateOfMonth);
    }

    public static Date getRandomDateBetween(Date min, Date max) {
        checkNotNull(min);
        checkNotNull(max);

        if (max.before(min))
            throw new IllegalArgumentException("Min date parameter must be before max date parameter");

        long randomTimeMillis = getRandomLongBetween(min.getTime(), max.getTime());
        return new Date(randomTimeMillis);
    }

}
