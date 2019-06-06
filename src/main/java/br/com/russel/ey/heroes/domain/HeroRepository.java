package br.com.russel.ey.heroes.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {
	
	List<Hero> findByDeletionDateIsNull();

}