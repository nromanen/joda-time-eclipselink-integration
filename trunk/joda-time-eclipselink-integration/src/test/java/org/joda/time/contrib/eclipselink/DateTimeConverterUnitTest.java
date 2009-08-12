package org.joda.time.contrib.eclipselink;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.junit.Test;

public class DateTimeConverterUnitTest {

    @Test
    public void shouldConvertDatetoDateTime() throws Exception {
        DateTimeConverter converter = new DateTimeConverter();
        DateTime expectedDateTime = new DateTime(2008, 9, 30, 22, 04, 59, 0);
        Calendar cal = new GregorianCalendar(2008, 9 - 1, 30, 22, 04, 59);
        DateTime convertedValue = (DateTime) converter.convertDataValueToObjectValue(cal.getTime(), null);
        assertEquals(expectedDateTime, convertedValue);
    }

    @Test
    public void shouldConvertDateTimeToDate() throws Exception {
        DateTimeConverter converter = new DateTimeConverter();
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(2008, 9 - 1, 30, 22, 15, 59);
        Date expectedDate = cal.getTime();

        DateTime valueToConvert = new DateTime(2008, 9, 30, 22, 15, 59, 0);
        Date convertedValue = (Date) converter.convertObjectValueToDataValue(valueToConvert, null);
        assertEquals(expectedDate.toString(), convertedValue.toString());
    }
}
