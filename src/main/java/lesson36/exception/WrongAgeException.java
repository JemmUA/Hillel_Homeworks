package lesson36.exception;

import java.io.IOException;

public class WrongAgeException extends IOException {
    public WrongAgeException(String message) {
        super(message);
    }
}
