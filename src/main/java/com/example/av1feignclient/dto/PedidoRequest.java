package com.example.av1feignclient.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoRequest {

    private LocalDate data;
    private BigDecimal valorTotal;
    private String nomeUsuario;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
