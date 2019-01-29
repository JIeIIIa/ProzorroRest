package com.gmail.onishchenko.oleksii.prozorrorest.controller;

import com.gmail.onishchenko.oleksii.prozorrorest.exception.ProzorroRestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MainAdviceController {

    private static final Logger LOG = LogManager.getLogger(MainAdviceController.class);

    @ExceptionHandler(value = {ProzorroRestException.class})
    @ResponseBody
    public ResponseEntity<String> error(ProzorroRestException exception) {
        LOG.warn("message: {}", exception.getMessage());
        LOG.debug("{}", exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("{\"error\":\"" + exception.getMessage() + "\"}");
    }
}
