package com.example.av1feignclient.service;

import com.example.av1feignclient.dto.UsuarioCadastroResponse;
import com.example.av1feignclient.interfaces.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioClient usuarioClient;

    public UsuarioCadastroResponse buscarUsuarioPorNome(String nome) {
        try {
            UsuarioCadastroResponse usuario = usuarioClient.buscarPorNome(nome);
            if (usuario == null) {
                throw new RuntimeException("Usuário com nome '" + nome + "' não encontrado.");
            }
            return usuario;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível buscar o usuário. Serviço de usuários pode estar indisponível.", e);
        }
    }


}
