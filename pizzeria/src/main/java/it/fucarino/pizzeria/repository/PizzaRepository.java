package it.fucarino.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.fucarino.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

}
