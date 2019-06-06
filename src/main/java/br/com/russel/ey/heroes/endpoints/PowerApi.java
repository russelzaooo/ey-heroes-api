package br.com.russel.ey.heroes.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.russel.ey.heroes.domain.Power;
import br.com.russel.ey.heroes.domain.PowerRepository;

@RestController
class PowerApi {

	private final PowerRepository powerRepo;

	PowerApi(PowerRepository powerRepo) {
		super();
		this.powerRepo = powerRepo;
	}

	@GetMapping("/powers")
	List<Power> list() {
		return powerRepo.findAll();
	}

}
