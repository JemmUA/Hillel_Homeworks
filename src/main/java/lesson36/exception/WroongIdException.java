package lesson36.exception;

import java.io.IOException;

public class WroongIdException extends IOException {
    public WroongIdException(String message) {
        super(message);
    }
}
