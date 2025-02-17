package intermediate;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static tools.Constants.__;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AboutLocale {

    @Test
    public void localizedOutputOfDates() {
        Calendar cal = Calendar.getInstance();
        cal.set(2011, 3, 3);
        Date date = cal.getTime();
        Locale localeBR = new Locale("pt", "BR"); // portuguese, Brazil
        DateFormat dateformatBR = DateFormat.getDateInstance(DateFormat.FULL, localeBR);
        assertEquals(dateformatBR.format(date), __);

        Locale localeJA = new Locale("ja"); // Japan
        DateFormat dateformatJA = DateFormat.getDateInstance(DateFormat.FULL, localeJA);
        // Well if you don't know how to type these characters, try "de", "it" or "us" ;-)
        assertEquals(dateformatJA.format(date), __);
    }

    @Test
    public void getCountryInformation() {
        Locale locBR = new Locale("pt", "BR");
        assertEquals(locBR.getDisplayCountry(), __);
        assertEquals(locBR.getDisplayCountry(locBR), __);

        Locale locCH = new Locale("it", "CH");
        assertEquals(locCH.getDisplayCountry(), __);
        assertEquals(locCH.getDisplayCountry(locCH), __);
        assertEquals(locCH.getDisplayCountry(new Locale("de", "CH")), __);
    }

    @Test
    public void formatCurrency() {
        float someAmount = 442.23f; // Don't use floats for money in real life. Really. It's a bad idea.
        Locale locBR = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(locBR);
        assertEquals(nf.format(someAmount), __);
    }
}
