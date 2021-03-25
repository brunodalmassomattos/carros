package com.udamy.carros.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.udamy.carros.api.entity.Carro;

public interface ICarrosRepository extends CrudRepository<Carro, Long> {
	List<Carro> findByTipo(String tipo);
}
