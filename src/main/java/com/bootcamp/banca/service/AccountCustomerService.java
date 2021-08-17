package com.bootcamp.banca.service;

import com.bootcamp.banca.bean.RequestCustomerAccountBean;
import com.bootcamp.banca.model.AccountCustomerEntity;

import reactor.core.publisher.Mono;

public interface AccountCustomerService
{
    public Mono<AccountCustomerEntity> createClientAccount(RequestCustomerAccountBean accClientBean,
                                                         String documentNumber);
    public Mono<AccountCustomerEntity> getAccountClient(String accountNumer, String documentNumber);
}
