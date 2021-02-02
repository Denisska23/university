package ua.com.foxminded.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.TransientObjectException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@ControllerAdvice
class AdviceController {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
        return defaultFrontErrResponse(exception);
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleNullPointerException(NullPointerException exception) {
        return defaultFrontErrResponse(exception);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        return defaultFrontErrResponse(exception);
    }

    @ExceptionHandler(TransientObjectException.class)
    public ModelAndView handleTransientObjectException(TransientObjectException exception) {
        return defaultFrontErrResponse(exception);
    }

    private ModelAndView defaultFrontErrResponse(Exception exception) {
        log.error("[ ERROR ] -> ", exception);
        ModelAndView modelAndView = new ModelAndView("exceptions/exceptionMessage");
        modelAndView.addObject("message", exception.getMessage());
        Optional.ofNullable(exception.getCause()).ifPresent(cause -> modelAndView.addObject("cause", cause));
        modelAndView.addObject("stackTrace", Stream.of(exception.getStackTrace()).map(StackTraceElement::toString).reduce((s1, s2) -> "\n" + s1 + "\n" + s2));
        return modelAndView;
    }
}
