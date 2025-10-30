package com.example.av1feignclient.dto;

import java.util.List;

public class UsuarioCadastroResponse {
    private Integer id;
    private String nome;
    private String cpf;
    private Integer status;
    private List<PedidoResponse> pedidos;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public List<PedidoResponse> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<PedidoResponse> pedidos) {
        this.pedidos = pedidos;
    }
}
