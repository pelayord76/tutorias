package com.spring.start.plan;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.start.curso.Curso;
import com.spring.start.enmarca.Enmarca;
import com.spring.start.tutor.Tutor;

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

	@OneToMany(mappedBy = "plan")
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private Set<Enmarca> enmarca = new HashSet<>();

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

	public Set<Enmarca> getEnmarca() {
		return enmarca;
	}

	public void setEnmarca(Set<Enmarca> enmarca) {
		this.enmarca = enmarca;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", nombre=" + nombre + ", tutor=" + tutor + ", curso=" + curso + ", actividades="
				+ enmarca + "]";
	}
}