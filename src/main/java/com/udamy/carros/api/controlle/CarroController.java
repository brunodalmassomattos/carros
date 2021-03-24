package com.udamy.carros.api.controlle;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udamy.carros.api.dtos.Carro;
import com.udamy.carros.api.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

	private CarroService carroService = new CarroService();

	@GetMapping
	public List<Carro> getCarros() {
		return this.carroService.getCarros();
	}

}
