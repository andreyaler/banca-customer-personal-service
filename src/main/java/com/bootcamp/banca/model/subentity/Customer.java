package com.bootcamp.banca.model.subentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Customer
{
    private String _id;
    private String documentNumber;
}
