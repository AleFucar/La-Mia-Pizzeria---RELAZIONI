package it.fucarino.pizzeria.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Ingredienti")
public class Ingredienti {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Devi inserire il nome dell'ingrediente")
	@Column(name = "name", nullable = false)
	private String name;
	
	
	@ManyToMany(mappedBy = "ingredienti")
	private List<Pizza> pizza;

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Pizza> getPizza() {
		return pizza;
	}


	public void setPizza(List<Pizza> pizza) {
		this.pizza = pizza;
	}
	
	
	
}
