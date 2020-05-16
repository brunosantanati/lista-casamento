package com.capgemini.casamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lista-de-casamento")
public class ConfirmarPresencaController {

	@GetMapping("confirmar-presenca")
	public ModelAndView confirmarPresenca() {
		
		ModelAndView modelAndView = new ModelAndView("confirmar-presenca");
		
		return modelAndView;
		
	}
	
}
