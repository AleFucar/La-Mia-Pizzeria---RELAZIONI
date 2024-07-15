 package it.fucarino.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.fucarino.pizzeria.model.Saldi;
import it.fucarino.pizzeria.repository.SaldiRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/saldi")
public class SaldiController {

	
	@Autowired
	private SaldiRepository saldiRepository;
	

	@PostMapping("/create")
	public String salva(@Valid @ModelAttribute("saldo")Saldi saldi, Model model, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return"/saldi/edit";
		}
		
		saldiRepository.save(saldi);
		
		return"redirect:/pizze/pizza/" + saldi.getPizza().getId();
	}
	
	
	
	
	
}
