package com.capgemini.casamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.casamento.model.Convidado;
import com.capgemini.casamento.repository.ConvidadoRepository;

@Controller
@RequestMapping("lista-de-casamento")
public class ConfirmarPresencaController {
	
	@Autowired
	ConvidadoRepository convidadoRepository;

	@GetMapping("confirmar-presenca")
	public ModelAndView mostrarPaginaConfirmarPresenca() {
		
		ModelAndView modelAndView = new ModelAndView("confirmar-presenca");
		
		modelAndView.addObject(new Convidado());
		
		return modelAndView;
		
	}
	
	@PostMapping("presenca-confirmada")
	public String confirmarPresenca(Convidado convidado) {
		convidadoRepository.save(convidado);
		return "presenca-confirmada";
	}
	
}
