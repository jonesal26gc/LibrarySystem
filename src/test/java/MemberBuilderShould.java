import builders.MemberBuilder;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class MemberBuilderShould {

    @Test
    public void
    create_some_members() {
        for (int person = 0; person < 10; person++) {
            System.out.println(MemberBuilder.aMember()
                    .withSurname("")
                    .build().toString());
        }
    }
}
