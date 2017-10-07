package com.london.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


//By default the methods in an @ControllerAdvice apply globally to all Controllers
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The Page is not constructed");
		mv.addObject("errorDescription", "The Page you are looking for is not available");
		mv.addObject("title", "404 Error Page");
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errorDescription", "The Product you are looking is not available");
		mv.addObject("title", "Product not available ");
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact the administrator for more info");
		mv.addObject("errorDescription", ex.toString());
		mv.addObject("title", "Error");
		return mv;
		
	}
	
}
