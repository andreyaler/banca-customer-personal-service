package com.bootcamp.banca.model.subentity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	private String _id;
	private String accountNumber;
	private String type;
	private Integer limitMovement;
	private BigDecimal amountTotal;
}
