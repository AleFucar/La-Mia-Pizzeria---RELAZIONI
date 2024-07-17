package it.fucarino.pizzeria.model;



import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	@NotBlank(message = "Devi inserire il nome della pizza.")
	private String name;
	
	
	@Column(name = "description")
	@NotBlank(message = "Devi inserire una descrizione")
	private String description;
	
	
	@NotNull(message = "Il prezzo non può essere nullo")
	@Column(name = "price", nullable = false)
	private double price;
	
	
	@NotBlank(message = "devi inserire una foto(Link)")
	@Column(name = "photo")
	private String photo;
	
	
	@OneToMany(mappedBy = "pizza")
	private List<Saldi> saldi;
	
	
	@ManyToMany()
	@JoinTable(name = "ingredienti_pizze", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingredienti_id"))
	private List<Ingredienti> ingredienti;
	
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


	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<Saldi> getSaldi() {
		return saldi;
	}

	public void setSaldi(List<Saldi> saldi) {
		this.saldi = saldi;
	}

	public List<Ingredienti> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingredienti> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	
	
	
	
}
