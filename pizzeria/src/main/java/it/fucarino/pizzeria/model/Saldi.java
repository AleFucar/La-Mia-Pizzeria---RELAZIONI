package it.fucarino.pizzeria.model;


import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Saldi {
	
	
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	
	@NotNull
	@Column(name = "data_inizio_offerta", nullable = false)
	private LocalDateTime dataInizio;
	
	@NotNull
	@Column(name = "data_fine_offerta", nullable = false)
	private LocalDateTime dataFine;


	@ManyToOne
	@JoinColumn(name = "pizza_id", nullable = false)
	private Pizza pizza;
	
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public LocalDateTime getDataInizio() {
		return dataInizio;
	}


	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}


	public LocalDateTime getDataFine() {
		return dataFine;
	}


	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Pizza getPizza() {
		return pizza;
	}


	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
	
	
	
}
