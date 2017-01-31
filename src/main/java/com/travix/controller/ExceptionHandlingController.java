package com.travix.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlingController
{
    private final String GENERAL_VIEW_NAME = "error/general";

    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView exception(final Exception exception)
    {
        this.printLog(exception);

        final ModelAndView modelAndView = new ModelAndView(this.GENERAL_VIEW_NAME);
        return modelAndView;
    }

    /**
     *  Just simulation for Jog4j API.
     * @param exception
     */
    private void printLog(final Exception exception)
    {
        exception.printStackTrace();
    }
}