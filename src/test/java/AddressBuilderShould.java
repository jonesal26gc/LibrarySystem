import application.model.Address;
import builders.AddressBuilder;
import com.neovisionaries.i18n.CountryCode;
import org.junit.Test;

import java.util.ArrayList;

public class AddressBuilderShould {

    @Test
    public void
    build_some_addresses() {

        ArrayList<Address> addresses = new ArrayList<Address>();

        for (int i = 2; i < 22; i = i + 2) {
            addresses.add(
                    AddressBuilder.anAddress()
                            .withStreetNameLine1(i + " Grange Close")
                            .withTown("Hitchin")
                            .withCity("Herts")
                            .withPostcode("SG4 9HD")
                            .withCountry(CountryCode.GB.getAlpha3())
                            .build());
            ;
        }

        for (Address address : addresses) {
            System.out.println(address.toString());
        }
    }

    @Test
    public void
    auto_build_an_address() {
        for (int i = 0; i < 20; i++) {
            Address a1 = AddressBuilder.anAddress().withStreetNameLine1("").build();
            System.out.println(a1.toString());
        }

    }
}
