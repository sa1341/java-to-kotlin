import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailAddressTest {

    @Test
    public void 테스트() throws Exception{

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            EmailAddress.parse("a79007714gmail.com");
        });
    }
}