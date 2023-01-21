package lesson36.service;

import lesson36.exception.WrongAgeException;
import lesson36.exception.WrongGenderException;
import lesson36.exception.WrongNameException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanServiceTest {

    HumanService humanService = new HumanService();

    @BeforeAll
    static void preparingToTest() {
        System.out.println("Tests are starting.");
    }

    @AfterAll
    static void afterPartyTest() {
        System.out.println("All tests are finished. Cup of coffee?");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Preparing test.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clean up after the test.");
    }

    @Test
    void validateIfNameIsEmptyTest() {
        WrongNameException wrongNameException = assertThrows(WrongNameException.class, () -> humanService.validateName(""));
        assertEquals("Name is null or empty", wrongNameException.getMessage());
        System.out.println("IfNameIsEmptyTest :" + wrongNameException.getMessage());
    }

        @Test
    void validateIfNameIsNullTest() {
        WrongNameException wrongNameException = assertThrows(WrongNameException.class, () -> humanService.validateName(null));
        assertEquals("Name is null or empty", wrongNameException.getMessage());
        System.out.println("IfNameIsNullTest :" + wrongNameException.getMessage());
    }

    @Test
    void validateIfAgeIsNullTest() {
        WrongAgeException wrongAgeException = assertThrows(WrongAgeException.class, () -> humanService.validateAge(null));
        assertEquals("Age is null", wrongAgeException.getMessage());
        System.out.println("IfAgeIsNullTest: " + wrongAgeException.getMessage());
    }

    @Test
    void validateIfAgeIsNegativeTest() {
        WrongAgeException wrongAgeException = assertThrows(WrongAgeException.class, () -> humanService.validateAge(-1));
        assertEquals("Age is negative", wrongAgeException.getMessage());
        System.out.println("IfAgeIsNegativeTest: " + wrongAgeException.getMessage());
    }

    @Test
    void validateIfAgeIsTeenAgerTest() {
        WrongAgeException wrongAgeException = assertThrows(WrongAgeException.class, () -> humanService.validateAge(17));
        assertEquals("Human is teenager", wrongAgeException.getMessage());
        System.out.println("IfAgeIsTeenAgerTest: " + wrongAgeException.getMessage());
    }

    @Test
    void validIfGenderIsWrong() {
        WrongGenderException wrongGenderException = assertThrows(WrongGenderException.class, () -> humanService.validateGender("men"));
        assertEquals("Gender is wrong", wrongGenderException.getMessage());
        System.out.println("IfGenderIsWrong: " + wrongGenderException.getMessage());
    }
}