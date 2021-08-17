package com.bootcamp.banca.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.banca.model.CustomerEntity;

import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<CustomerEntity, String> {

	Mono<CustomerEntity> findByDocumentNumberAndIsActive(String documentNumber, Boolean isActive);

	Mono<CustomerEntity> findByDocumentNumber(String documentNumber);
}
