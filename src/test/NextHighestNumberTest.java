package test;

import com.company.NextHighestNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NextHighestNumberTest {


    NextHighestNumber nextHighestNumber = new NextHighestNumber();


    @Test
    void isStringInInteger() {
        //Boolean expected = true;
        Boolean actual = nextHighestNumber.isStringInInteger("12345pp33");
        assertFalse(actual);
    }

    @Test
    void isLengthGreaterThan1() {
        assertFalse(nextHighestNumber.isLengthGreaterThan1("2"));
    }

    @Test
    void isCurrentDigitValueGreaterThanLeftDigitValue() {
        assertFalse(nextHighestNumber.isCurrentDigitValueGreaterThanLeftDigitValue(3, 5));
    }

//    @Test
//    void isLessThanMinIntegerValue() {
//        assertTrue(nextHighestNumber.isLessThanMinIntegerValue("-2147483649"));
//    }

    @Test
    void getNextHighestNumber() {
        int expected = 12354;
        int actual = nextHighestNumber.getNextHighestNumber("12345");
        assertEquals(expected, actual);
    }


    @Test
    //test on most significant digit swap test
    void getNextHighestNumberWith12() {
        int expected =  21; //35421;
        int actual = nextHighestNumber.getNextHighestNumber("12");
        assertEquals(expected, actual);
    }

    @Test
    void sortValueAscending() {
        assertEquals((nextHighestNumber.sortValueAscending("3542")), ("2345"));

    }

    @Test
        //test on swap happens and length > 2
    void getNextHighestNumberWith35421() {
        int expected =  41235; //35421;
        int actual = nextHighestNumber.getNextHighestNumber("35421");
        assertEquals(expected, actual);
    }

    @Test
    void getNextHighestNumberWithNegative() {
        int expected = -12345;
        int actual = nextHighestNumber.getNextHighestNumber("-12354");
        assertEquals(expected, actual);
    }



}