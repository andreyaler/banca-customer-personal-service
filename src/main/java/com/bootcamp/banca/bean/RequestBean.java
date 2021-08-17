package com.bootcamp.banca.bean;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBean
{
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String documentType;
    @NotNull
    private String documentNumber;
}
