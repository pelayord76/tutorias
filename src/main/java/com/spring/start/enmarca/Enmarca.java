package com.spring.start.enmarca;

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
	@JoinColumn(name = "plan_id")
	Plan plan;

	@ManyToOne
	@JoinColumn(name = "actividad_id")
	Actividad actividad;
}