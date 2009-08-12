package org.joda.time.contrib.eclipselink;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.LocalDate;
import org.junit.Test;

public class LocalDateConverterUnitTest {

    @Test
    public void shouldConvertDatetoLocalDate() throws Exception {
        LocalDateConverter converter = new LocalDateConverter();
        LocalDate expectedLocalDate = new LocalDate(2008, 9, 30);

        Calendar valueToConvert = GregorianCalendar.getInstance();
        valueToConvert.set(2008, 9 - 1, 30);
        LocalDate convertedValue = (LocalDate) converter.convertDataValueToObjectValue(valueToConvert.getTime(), null);

        assertEquals(expectedLocalDate, convertedValue);
    }

    @Test
    public void shouldConvertLocalDateToDate() throws Exception {
        LocalDateConverter converter = new LocalDateConverter();
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(2008, 9 - 1, 30, 0, 0, 0);
        Date expectedDate = cal.getTime();

        LocalDate valueToConvert = new LocalDate(2008, 9, 30);
        Date convertedValue = (Date) converter.convertObjectValueToDataValue(valueToConvert, null);

        assertEquals(expectedDate.toString(), convertedValue.toString());
    }
}
