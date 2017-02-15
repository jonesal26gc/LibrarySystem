import com.neovisionaries.i18n.CountryCode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountryCodeShould {

    @Test
    public void
    list_all_countries(){

        List<CountryCode> countries = CountryCode.findByName("^U.*");

        for (CountryCode element : countries) {
            System.out.println(element.getAlpha3() + " = " + element.getName());
        }

        System.out.println(CountryCode.GB.getAlpha3());




    }


}
