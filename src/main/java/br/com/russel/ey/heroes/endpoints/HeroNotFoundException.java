package br.com.russel.ey.heroes.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Hero not found")
public class HeroNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
}