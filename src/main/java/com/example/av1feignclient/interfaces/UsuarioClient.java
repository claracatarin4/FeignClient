package com.example.av1feignclient.interfaces;

import com.example.av1feignclient.dto.UsuarioCadastroRequest;
import com.example.av1feignclient.dto.UsuarioCadastroResponse;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "FeignClient", url = "http://10.136.36.216:8081")
public interface UsuarioClient {
    @GetMapping("api/usuarios/listar")
    List<UsuarioCadastroResponse> listarUsuario();
    @PostMapping("/api/usuarios/criar")
    UsuarioCadastroResponse salvarUsuario(UsuarioCadastroRequest request);
}
