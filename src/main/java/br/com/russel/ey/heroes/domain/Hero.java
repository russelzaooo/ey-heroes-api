package br.com.russel.ey.heroes.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@JsonIgnore
	@Column(nullable = false)
	private Date creationDate = new Date();

	private Date deletionDate;

	@Column(nullable = false)
	private String name;

	@ManyToMany(cascade = CascadeType.REFRESH)
	private Set<Power> powers = new HashSet<>();

	@ManyToOne(cascade = CascadeType.REFRESH)
	private Universe universe;

	public Hero() {
		super();
		// Dont use
	}

	public Hero(Integer id, String name, Universe universe) {
		super();
		this.id = id;
		this.name = name;
		this.universe = universe;
	}

	public Integer getId() {
		return id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getDeletionDate() {
		return deletionDate;
	}

	public String getName() {
		return name;
	}

	public Set<Power> getPowers() {
		return powers;
	}

	public Universe getUniverse() {
		return universe;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPowers(Set<Power> powers) {
		this.powers = powers;
	}
	
	public void setUniverse(Universe universe) {
		this.universe = universe;
	}

	public void delete() {
		this.deletionDate = new Date();
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", creationDate=" + creationDate + ", deletionDate=" + deletionDate + ", name="
				+ name + ", powers=" + powers + ", universe=" + universe + "]";
	}

}