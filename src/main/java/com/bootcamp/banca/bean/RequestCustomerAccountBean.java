package com.bootcamp.banca.bean;

import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class RequestCustomerAccountBean
{
    private String idAccount;
    private String accountNumber;
    private String type;
    @Nullable
    private Integer limitMovement;
    private BigDecimal amountTotal;
}
