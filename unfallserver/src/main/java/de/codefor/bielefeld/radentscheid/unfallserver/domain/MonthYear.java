package de.codefor.bielefeld.radentscheid.unfallserver.domain;

import java.util.Objects;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class MonthYear implements Comparable<MonthYear> {

    private final int month;

    private final int year;

    public MonthYear(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public int month() {
        return month;
    }

    public int year() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthYear monthYear = (MonthYear) o;
        return month == monthYear.month &&
                year == monthYear.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, year);
    }

    @Override
    public int compareTo(MonthYear o) {
        if (o == null) return 1;
        if (year > o.year) {
            return 1;
        } else if (year < o.year) {
            return -1;
        } else {
            return Integer.compare(month, o.month);
        }
    }
}
