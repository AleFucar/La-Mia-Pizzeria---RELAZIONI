package it.fucarino.pizzeria.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import it.fucarino.pizzeria.model.Pizza;
import it.fucarino.pizzeria.repository.PizzaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping
public class PizzaController {
	
	@Autowired
	private PizzaRepository repository;
	
	
	@GetMapping("/pizze")
	public String index(Model model) {
		
	    List<Pizza> pizza = repository.findAll();
		model.addAttribute("list", pizza);
		return"/pizze/index";
	}
	
	@GetMapping("/pizze/pizza/{id}")
	public String pizza(@PathVariable("id") Integer pizzaId,  Model model) {
		
		
		model.addAttribute("pizza", repository.getReferenceById(pizzaId));
		
		return"/pizze/pizza";
	}
	
	
	@GetMapping("/pizze/create")
	public String create(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return"/pizze/create";
	}
	
	@PostMapping("/pizze/create")
	public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {
			if (bindingResult.hasErrors()) {
				return"/pizze/create";
			}
			
			repository.save(formPizza);
			
			return"redirect:/pizze";
	}
	
	@PostMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") Integer id) {
		
		repository.deleteById(id);
		
		return"redirect:/pizze";
	}
	
	
	@GetMapping("/pizze/update/{id}")
	public String updatePizza(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("pizza", repository.getReferenceById(id));
		return"/pizze/update";
	}
	
	
	@PostMapping("/pizze/update/{id}")
	public String update(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return"/pizze/update";
		}
		
		repository.save(formPizza);
		
		return"redirect:/pizze";
}
}
