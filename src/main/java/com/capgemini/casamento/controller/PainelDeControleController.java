package com.capgemini.casamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.casamento.repository.ConvidadoRepository;

@Controller
@RequestMapping("/painel-de-controle")
public class PainelDeControleController {

	@Autowired
	ConvidadoRepository convidadoRepository;
	
	@GetMapping("home")
	public ModelAndView mostrarPainelDeControle() {
		
		ModelAndView modelAndView = new ModelAndView("painel-de-controle/home");
		
		modelAndView.addObject("convidados", convidadoRepository.findAll());
		
		return modelAndView;
		
	}
	
}
