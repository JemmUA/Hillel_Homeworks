package lesson36.exception;

import java.io.IOException;

public class WrongNameException extends IOException {
    public WrongNameException(String message) {
        super(message);
    }
}
