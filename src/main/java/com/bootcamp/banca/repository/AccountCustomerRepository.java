package com.bootcamp.banca.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bootcamp.banca.model.AccountCustomerEntity;

import reactor.core.publisher.Mono;

public interface AccountCustomerRepository extends ReactiveMongoRepository<AccountCustomerEntity, String>
{
    Mono<AccountCustomerEntity> findByCustomerDocumentNumberAndAccountType(String dodcumentNumber, String type);
    Mono<AccountCustomerEntity> findByAccountAccountNumberAndCustomerDocumentNumber(String accountNumber, String documentNumber);
    Mono<AccountCustomerEntity> findByCustomerDocumentNumber(String documentNumber);
}
