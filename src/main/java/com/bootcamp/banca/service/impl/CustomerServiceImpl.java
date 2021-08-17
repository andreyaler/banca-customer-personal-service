package com.bootcamp.banca.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.banca.bean.Constants;
import com.bootcamp.banca.bean.RequestBean;
import com.bootcamp.banca.model.CustomerEntity;
import com.bootcamp.banca.repository.CustomerRepository;
import com.bootcamp.banca.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository clientRepository;

	@Override
	public Mono<CustomerEntity> createClient(Mono<RequestBean> bean) {

		return bean.flatMap(requestBean -> {
			CustomerEntity clientEntity = new CustomerEntity();
			clientEntity.setFirstName(requestBean.getFirstName());
			clientEntity.setLastName(requestBean.getLastName());
			clientEntity.setDocumentNumber(requestBean.getDocumentNumber());
			clientEntity.setTypeClient(Constants.typePerson);
			clientEntity.setDocumentType(requestBean.getDocumentType());
			clientEntity.setIsActive(true);
			clientEntity.setCreatedAt(new Date());
			log.info("Guardando cliente...");

			return clientRepository.save(clientEntity);

		});
	}

	@Override
	public Flux<CustomerEntity> getClient() {
		return clientRepository.findAll();
	}

	@Override
	public Mono<CustomerEntity> getClient(String documentNumber) {
		return clientRepository.findByDocumentNumberAndIsActive(documentNumber, true);
	}

	@Override
	public Mono<CustomerEntity> updateClient(RequestBean bean, String documentNumber) {
		return clientRepository.findByDocumentNumber(documentNumber).flatMap(clientEntity -> {
			clientEntity.setFirstName(bean.getFirstName());
			clientEntity.setLastName(bean.getLastName());
			clientEntity.setModifiedAt(new Date());

			return clientRepository.save(clientEntity);
		});
	}

	@Override
	public Mono<CustomerEntity> deleteClient(String documentNumber) {
		return clientRepository.findByDocumentNumberAndIsActive(documentNumber, true).flatMap(clientEntity -> {
			clientEntity.setIsActive(false);

			return clientRepository.save(clientEntity);
		});
	}

}
