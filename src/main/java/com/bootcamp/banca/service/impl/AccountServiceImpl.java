package com.bootcamp.banca.service.impl;

import com.bootcamp.banca.bean.RequestCustomerAccountBean;
import com.bootcamp.banca.model.AccountCustomerEntity;
import com.bootcamp.banca.model.subentity.Account;
import com.bootcamp.banca.model.subentity.Customer;
import com.bootcamp.banca.repository.AccountCustomerRepository;
import com.bootcamp.banca.repository.CustomerRepository;
import com.bootcamp.banca.service.AccountCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AccountServiceImpl implements AccountCustomerService
{
    @Autowired
    AccountCustomerRepository accountClientRepository;

    @Autowired
    CustomerRepository clientRepository;

    @Override
    public Mono<AccountCustomerEntity> createClientAccount(RequestCustomerAccountBean accClientBean,
                                                         String documentNumber) {
        return clientRepository.findByDocumentNumber(documentNumber)
                .flatMap(clientEntity -> {
                    AccountCustomerEntity accountClientEntity = new AccountCustomerEntity();
                    Customer customer = new Customer(clientEntity.get_id(), clientEntity.getDocumentNumber());

                    List<Account> listAccount = new ArrayList<>();

                    Account account = new Account(accClientBean.getIdAccount(),
                            accClientBean.getAccountNumber(), accClientBean.getType(),
                            accClientBean.getLimitMovement(), accClientBean.getAmountTotal());

                    listAccount.add(account);

                    accountClientEntity.setCustomer(customer);
                    accountClientEntity.setAccount(listAccount);
                    accountClientEntity.setCreatedAt(new Date());

                    log.info("Guardando asignacion de cliente a cuenta : {}", accountClientEntity.toString() );

                    return accountClientRepository.findByCustomerDocumentNumber(
                            accountClientEntity.getCustomer().getDocumentNumber())
                            .flatMap(accountClientEntity1 -> {
                                accountClientEntity1.getAccount().add(account);
                                return accountClientRepository.findByCustomerDocumentNumberAndAccountType(
                                        accountClientEntity1.getCustomer().getDocumentNumber(),
                                        accClientBean.getType())
                                        .switchIfEmpty(accountClientRepository.save(accountClientEntity1));
                            })
                            .switchIfEmpty(accountClientRepository.save(accountClientEntity));
                });
    }

    @Override
    public Mono<AccountCustomerEntity> getAccountClient(String accountNumer, String documentNumber) {
        return accountClientRepository.findByAccountAccountNumberAndCustomerDocumentNumber(accountNumer, documentNumber);
    }
}
