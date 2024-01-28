package com.spring.start.curso;

import java.util.ArrayList;
import java.util.List;

import com.spring.start.plan.Plan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Curso {

	@Id
	private String nombre;

	@OneToMany(targetEntity = Plan.class, mappedBy = "curso", cascade = CascadeType.ALL)
	private List<Plan> planes = new ArrayList<Plan>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Plan> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Plan> planes) {
		this.planes = planes;
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + "]";
	}
}