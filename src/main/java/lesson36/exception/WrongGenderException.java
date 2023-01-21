package lesson36.exception;

import java.io.IOException;

public class WrongGenderException extends IOException {
    public WrongGenderException(String message) {
        super(message);
    }
}
