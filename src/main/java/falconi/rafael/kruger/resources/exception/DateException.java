package falconi.rafael.kruger.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DateException extends Exception {
    private static final long serialVersionUID = -7717691994704695707L;

    public DateException(String message) {
        super(message);
    }

}
