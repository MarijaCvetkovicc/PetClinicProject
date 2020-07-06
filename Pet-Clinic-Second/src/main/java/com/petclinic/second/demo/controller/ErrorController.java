package com.petclinic.second.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    /*
	@GetMapping(value = "globalException", params = "errorMessage")
	public ModelAndView getGlobalError(@RequestParam("errorMessage") String errorMessage) {
		System.out.println("=======================================");
		System.out.println("errorMessage: " + errorMessage);
		System.out.println("=======================================");
		
		ModelAndView modelAndView = new ModelAndView("error/globalException");
		modelAndView.addObject("errorMessage", errorMessage);
		return modelAndView;
	}
     */

    @GetMapping(value = "globalException")
    public ModelAndView getGlobalError(
            @ModelAttribute("errorMessage") String errorMessage
    ) {

        System.out.println("=======================================");
        System.out.println("errorMessage: " + errorMessage);
        System.out.println("=======================================");

        ModelAndView modelAndView = new ModelAndView("globalException.jsp");
        modelAndView.addObject("errorMessage", errorMessage);
       // modelAndView.addObject("errorObj", exception);

        return modelAndView;
    }
}
