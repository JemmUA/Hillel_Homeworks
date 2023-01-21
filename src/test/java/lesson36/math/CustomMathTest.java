package lesson36.math;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Just for tests
class CustomMathTest {
    CustomMath customMath = new CustomMath();

    @Order(2)
    @Test
    void ifIsNotFiveTest() {
        assertNotEquals(234, customMath.threePlusTwo());
        System.out.println("sum != " + customMath.threePlusTwo());
    }

    @Order(3)
    @Test
    void ifIsFiveTest() {
        assertEquals(5, customMath.threePlusTwo());
        System.out.println("sum = " + customMath.threePlusTwo());
    }

    @Order(1)
    @Test
    void ifThreePlusTwoEqialsFive() {
        assertTrue(customMath.threePlusTwoEqualsFive(), "customMath.threePlusTwo() == 5");
        System.out.println("sum = " + customMath.threePlusTwo() + ": is true");
    }

    @Test
    void ifThreePlusTwoIsNegative() {
        assertFalse(customMath.threePlusTwoIsNegative(), "customMath.threePlusTwo() == 5");
        System.out.println("sum 3+2 is negative - " + customMath.threePlusTwoIsNegative()   );
    }
}