package com.lucassilvs.confluentcloud.confluentcloudusecases.models.request;

import org.springframework.lang.NonNull;

public class UsuarioDadosContract {
    @NonNull
    private final int id;
    @NonNull
    private final String nome;
    @NonNull
    private final String saldo;

    public UsuarioDadosContract(int id, @NonNull String nome, @NonNull String saldo) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public String getSaldo() {
        return saldo;
    }
}
