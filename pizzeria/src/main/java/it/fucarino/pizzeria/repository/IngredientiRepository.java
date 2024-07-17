package it.fucarino.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fucarino.pizzeria.model.Ingredienti;

public interface IngredientiRepository extends JpaRepository<Ingredienti, Integer> {

}
