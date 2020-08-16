package de.codefor.bielefeld.radentscheid.unfallserver.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public class MonthYearTest {

    @Test
    public void testCompareTo() {
        // given
        MonthYear my052018 = new MonthYear(5, 2018);
        MonthYear my052019 = new MonthYear(5, 2019);
        MonthYear my052020 = new MonthYear(5, 2020);
        MonthYear my052019_2 = new MonthYear(5, 2019);
        MonthYear my062019 = new MonthYear(6, 2019);

        // when
        int c1 = my052018.compareTo(my052019);
        int c2 = my052020.compareTo(my052019);
        int c3 = my052019.compareTo(my052019_2);
        int c4 = my052019.compareTo(my062019);

        //then
        Assert.assertEquals(c1, -1);
        Assert.assertEquals(c2, 1);
        Assert.assertEquals(c3, 0);
        Assert.assertEquals(c4, -1);
    }
}