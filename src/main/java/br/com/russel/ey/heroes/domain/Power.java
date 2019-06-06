package br.com.russel.ey.heroes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Power {

	@Id
	private Integer id;

	@Column(nullable = false)
	private String name;

	public Power() {
		super();
		// Dont use
	}

	public Power(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Power [id=" + id + ", name=" + name + "]";
	}

}
