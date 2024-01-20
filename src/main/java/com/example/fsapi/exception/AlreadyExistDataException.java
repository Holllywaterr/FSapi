package com.example.fsapi.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
@SuppressWarnings("serial")
@NoArgsConstructor
public class AlreadyExistDataException extends RuntimeException {
    public AlreadyExistDataException(String message) {
        super(message);
    }
}
