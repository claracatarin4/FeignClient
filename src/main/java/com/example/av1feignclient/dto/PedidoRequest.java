package com.example.av1feignclient.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoRequest {

    private LocalDate data;
    private BigDecimal valorTotal;
    private Integer status;
    private UsuarioCadastroRequest request;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UsuarioCadastroRequest getUsuario() {
        return request;
    }

    public void setUsuario(UsuarioCadastroRequest request) {
        this.request = request;
    }
}
