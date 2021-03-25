package com.udamy.carros.api.controlle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udamy.carros.api.entity.Carro;
import com.udamy.carros.api.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@GetMapping
	public List<Carro> getCarros() {
		return this.carroService.getCarros();
	}

	@GetMapping("/{id}")
	public Optional<Carro> getCarrosById(@PathVariable("id") long id) {
		return this.carroService.getCarrosById(id);
	}

	@GetMapping("/tipo/{tipo}")
	public List<Carro> getCarrosById(@PathVariable("tipo") String tipo) {
		return this.carroService.getCarrosByTipo(tipo);
	}

	@PostMapping
	public String postCarroSalvar(@RequestBody Carro carroRequest) {
		Carro carro = this.carroService.salvarCarros(carroRequest);

		return "Carro salvo com sucesso! ID: " + carro.getId();
	}

	@PutMapping("/{id}")
	public String put(@PathVariable("id") Long id, @RequestBody Carro carroRequest) {
		Carro carro = this.carroService.atualizarCarros(id, carroRequest);

		return "Atualizacao realizada com sucesso!";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.carroService.delete(id);

		return "Exclusao realizada com sucesso!";
	}
	
}
