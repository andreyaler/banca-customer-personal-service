package com.bootcamp.banca.service;

import com.bootcamp.banca.bean.RequestBean;
import com.bootcamp.banca.model.CustomerEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
	public Mono<CustomerEntity> createClient(Mono<RequestBean> bean) throws Exception;

	public Flux<CustomerEntity> getClient();

	public Mono<CustomerEntity> getClient(String documentNumber);

	public Mono<CustomerEntity> updateClient(RequestBean bean, String documentNumber);

	public Mono<CustomerEntity> deleteClient(String documentNumber);
}
