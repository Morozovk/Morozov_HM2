import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleJunitTest {

    @Test
    void firstTest() {
        Assertions.assertTrue(3 > 2);
    }

}