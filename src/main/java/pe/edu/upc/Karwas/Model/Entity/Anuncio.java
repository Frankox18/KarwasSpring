package pe.edu.upc.Karwas.Model.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "anuncios")
@Getter
@Setter
public class Anuncio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Min(value = 0, message = "El Precio del servicio debe ser mayor a 0")
	@Column(name = "precioServicio", nullable = false)
	private Integer precioServicio;
	
	@Min(value = 10, message = "El tiempo del anuncio debe ser mayor a 10 segundos y menor a 60 segundos")
	@Max(value = 60, message = "El tiempo del anuncio debe ser mayor a 10 segundos y menor a 60 segundos")
	@Column(name = "tiempoAnuncio", nullable = false)
	private Integer tiempoAnuncio;
	
	@NotNull(message = "Por favor, indique la sucursal del anuncio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sucursal_id")
	private Sucursal sucursal;
	
}