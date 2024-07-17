package it.fucarino.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.fucarino.pizzeria.model.Ingredienti;
import it.fucarino.pizzeria.repository.IngredientiRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredienti")
public class IngredientiController {

	@Autowired
	public IngredientiRepository ingredientiRepository;
	
	@GetMapping
	public String index(Model model) {
		
		model.addAttribute("listaIngredienti", ingredientiRepository.findAll());
		model.addAttribute("ingrediente", new Ingredienti());
		
		return"/ingredienti/index";
	}
	
	
	@PostMapping("/create")
	public String salva(@Valid @ModelAttribute("ingrediente") Ingredienti ingrediente, BindingResult bindingResult, Model model ){
		
		if (bindingResult.hasErrors()) {
			return"/ingredienti/index";
		}
		
		ingredientiRepository.save(ingrediente);
		
		return"redirect:/ingredienti";
	}
	
}
