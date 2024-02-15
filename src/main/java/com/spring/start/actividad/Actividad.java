package com.spring.start.actividad;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.enmarca.Enmarca;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean obligatoria;
	private String nombre;
	private String descripcion;

	@OneToMany(mappedBy = "actividad", targetEntity = Enmarca.class)
	@JsonManagedReference
	private Set<Enmarca> enmarca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isObligatoria() {
		return obligatoria;
	}

	public void setObligatoria(boolean obligatoria) {
		this.obligatoria = obligatoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Enmarca> getEnmarca() {
		return enmarca;
	}

	public void setEnmarca(Set<Enmarca> enmarca) {
		this.enmarca = enmarca;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", obligatoria=" + obligatoria + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", planes=" + enmarca + "]";
	}
}