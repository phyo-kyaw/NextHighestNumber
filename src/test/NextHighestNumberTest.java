package test;

import com.company.NextHighestNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextHighestNumberTest {


    NextHighestNumber nextHighestNumber = new NextHighestNumber();


    @Test
    void getNextHighestNumber() {
        int expected = 12354;
        int actual = nextHighestNumber.getNextHighestNumber(12345);
        assertEquals(expected, actual);
    }
}