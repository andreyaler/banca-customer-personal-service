package com.bootcamp.banca.model;

import com.bootcamp.banca.model.subentity.Account;
import com.bootcamp.banca.model.subentity.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection = "accountClientPerson")
@ToString
@NoArgsConstructor
public class AccountCustomerEntity
{
    @Id
    private String _id;

    private Customer customer;
    private List<Account> account;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date modifiedAt;

    @Nullable
    private BigDecimal limitTransaction;


}
