package com.example.av1feignclient.service;

import com.example.av1feignclient.dto.PedidoRequest;
import com.example.av1feignclient.dto.PedidoResponse;
import com.example.av1feignclient.dto.UsuarioCadastroRequest;
import com.example.av1feignclient.dto.UsuarioCadastroResponse;
import com.example.av1feignclient.entity.Pedido;
import com.example.av1feignclient.interfaces.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.stream.Collectors;
public class UsuarioService {

    @Autowired
    private final UsuarioClient usuarioClient;

    public UsuarioService(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    public Integer criarUsuario(UsuarioCadastroRequest request){

    }


}
