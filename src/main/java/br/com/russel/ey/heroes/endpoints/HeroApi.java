package br.com.russel.ey.heroes.endpoints;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.russel.ey.heroes.domain.Hero;
import br.com.russel.ey.heroes.domain.HeroRepository;

@RestController
class HeroApi {

	private final HeroRepository heroRepo;

	HeroApi(HeroRepository heroHepo) {
		super();
		this.heroRepo = heroHepo;
	}

	@GetMapping("/heroes")
	List<Hero> list() {
		return heroRepo.findByDeletionDateIsNull();
	}

	@GetMapping("/heroes/{id}")
	Hero findById(@PathVariable Integer id) {
		Optional<Hero> heroOp = heroRepo.findById(id);

		if (heroOp.isPresent()) {
			return heroOp.get();
		} else {
			throw new HeroNotFoundException();
		}
	}
	
	@PostMapping("/heroes")
	ResponseEntity<ResourcePath> create(@RequestBody Hero newHero, HttpServletRequest request) throws URISyntaxException {
		heroRepo.save(newHero);
		ResourcePath path = new ResourcePath(request.getRequestURI() + "/" + newHero.getId(), newHero.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(path);
	}
	
	@PutMapping("/heroes/{id}")
	Hero edit(@RequestBody Hero editedHero, @PathVariable Integer id) {
	
	    return heroRepo.findById(id)
	      .map(hero -> {
	    	  hero.setName(editedHero.getName());
	    	  hero.setUniverse(editedHero.getUniverse());
	    	  hero.setPowers(editedHero.getPowers());
	        return heroRepo.save(hero);
	      })
	      .orElseGet(() -> {
	    	  editedHero.setId(id);
	        return heroRepo.save(editedHero);
	      });
	  }
	
	@DeleteMapping("/heroes/{id}")
	ResponseEntity<String> delete(@PathVariable Integer id) {
		Hero hero = findById(id);
		hero.delete();
		heroRepo.save(hero);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
