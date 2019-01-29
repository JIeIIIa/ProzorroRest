package com.gmail.onishchenko.oleksii.prozorrorest.controller;

import com.gmail.onishchenko.oleksii.prozorrorest.exception.ProzorroRestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MainAdviceController {
    @ExceptionHandler(value = {ProzorroRestException.class})
    @ResponseBody
    public ResponseEntity<String> error(ProzorroRestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("{\"error\":\"" + exception.getMessage() + "\"}");
    }
}
