package com.udamy.carros.api.service;

import java.util.Arrays;
import java.util.List;

import com.udamy.carros.api.dtos.Carro;

public class CarroService {

	public List<Carro> getCarros() {
		return Arrays.asList(new Carro(1L, "Fusca"), new Carro(2L, "City"), new Carro(3L, "Celta"));
	}

}
