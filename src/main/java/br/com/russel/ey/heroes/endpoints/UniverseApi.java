package br.com.russel.ey.heroes.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russel.ey.heroes.domain.Universe;
import br.com.russel.ey.heroes.domain.UniverseRepository;

@RestController
class UniverseApi {

	private final UniverseRepository universeRepo;

	UniverseApi(UniverseRepository universeRepo) {
		super();
		this.universeRepo = universeRepo;
	}

	@GetMapping("/universes")
	List<Universe> list() {
		return universeRepo.findAll();
	}

}
