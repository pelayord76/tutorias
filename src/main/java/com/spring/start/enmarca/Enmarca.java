package com.spring.start.enmarca;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.actividad.Actividad;
import com.spring.start.plan.Plan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enmarca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "actividad_id")
	@JsonBackReference
	private Actividad actividad;

	@ManyToOne
	@JoinColumn(name = "plan_id")
	@JsonBackReference
	private Plan plan;
	
	private String fecha;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Enmarca [id=" + id + ", actividad=" + actividad + ", plan=" + plan + ", fecha=" + fecha + "]";
	}
}