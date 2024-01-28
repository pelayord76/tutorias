package com.spring.start.plan;

import java.util.ArrayList;
import java.util.List;

import com.spring.start.curso.Curso;
import com.spring.start.enmarca.Enmarca;
import com.spring.start.tutor.Tutor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;

	@OneToOne(targetEntity = Tutor.class, mappedBy = "plan")
	private Tutor tutor;

	@ManyToOne
	@JoinColumn(name = "FK_CURSO")
	private Curso curso;

	@OneToMany(targetEntity = Enmarca.class, mappedBy = "plan", cascade = CascadeType.ALL)
	private List<Enmarca> actividades = new ArrayList<Enmarca>();

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public List<Enmarca> getActividades() {
		return actividades;
	}

	public void setActividades(List<Enmarca> actividades) {
		this.actividades = actividades;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", nombre=" + nombre + ", tutor=" + tutor + ", curso=" + curso + ", actividades="
				+ actividades + "]";
	}
}