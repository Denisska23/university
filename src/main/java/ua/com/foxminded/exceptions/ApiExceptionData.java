package ua.com.foxminded.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiExceptionData {
    private String message;
    private LocalDateTime timestamp;
    private String details;

    public ApiExceptionData(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }


}
