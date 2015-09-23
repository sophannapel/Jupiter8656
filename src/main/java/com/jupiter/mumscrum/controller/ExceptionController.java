package com.jupiter.mumscrum.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.jupiter.mumscrum.exception.CustomException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ce) {
		ModelAndView model= new ModelAndView("error");
		model.addObject("errCode", ce.getErrCode());
		model.addObject("errMsg", ce.getErrMessage());
		return model;
	}
}
