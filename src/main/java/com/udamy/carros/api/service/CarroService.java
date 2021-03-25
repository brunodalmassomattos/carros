package com.udamy.carros.api.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udamy.carros.api.entity.Carro;
import com.udamy.carros.api.repository.ICarrosRepository;

@Service
public class CarroService {

	@Autowired
	private ICarrosRepository carrosRepository;

	public List<Carro> getCarros() {
		return (List<Carro>) this.carrosRepository.findAll();
	}

	public Optional<Carro> getCarrosById(Long id) {
		return this.carrosRepository.findById(id);
	}

	public List<Carro> getCarrosByTipo(String tipo) {
		return (List<Carro>) this.carrosRepository.findByTipo(tipo);
	}

	public Carro salvarCarros(Carro carro) {
		return this.carrosRepository.save(carro);
	}

	public Carro atualizarCarros(Long id, Carro carroRequest) {
		if (!id.equals(null)) {
			carroRequest.setId(id);

			this.carrosRepository.save(carroRequest);
		} else {
			throw new RuntimeErrorException(null, "Não foi possivel atualizar o registro!");
		}

		return carroRequest;
	}

	public void delete(Long id) {
		if (!id.equals(null)) {
			this.carrosRepository.deleteById(id);
		} else {
			throw new RuntimeErrorException(null, "Não foi possivel excluir o registro!");
		}

	}

	public List<Carro> getCarrosMock() {
		return Arrays.asList(new Carro(1L, "Fusca"), new Carro(2L, "City"), new Carro(3L, "Celta"));
	}

}
