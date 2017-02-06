import application.Address;
import builders.AddressBuilder;
import org.junit.Test;

import java.util.ArrayList;

public class AddressBuilderShould {

    @Test
    public void
    build_an_address() {

        ArrayList<Address> addresses = new ArrayList<Address>();

        for (int i = 2; i < 22; i=i+2) {
            addresses.add(
                    AddressBuilder.anAddress()
                            .withStreetNameFirst(i + " Grange Close")
                            .withTown("Hitchin")
                            .withCity("Herts")
                            .withPostcode("SG4 9HD")
                            .withCountry(application.Country.UNITED_KINGDOM)
                            .build());
            ;
        }

        for (Address address : addresses){
            System.out.println(address.toString());
        }
    }
}
