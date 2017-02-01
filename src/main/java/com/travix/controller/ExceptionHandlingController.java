package com.travix.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class to handler Exceptions.
 */
@ControllerAdvice
public class ExceptionHandlingController
{
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView exception(final Exception exception)
	{
		exception.printStackTrace();
		final ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
}