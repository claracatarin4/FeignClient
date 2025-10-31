package com.example.av1feignclient.interfaces;

import com.example.av1feignclient.dto.UsuarioCadastroRequest;
import com.example.av1feignclient.dto.UsuarioCadastroResponse;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "FeignClient", url = "http://10.136.36.216:8080/api/usuarios/")
public interface UsuarioClient {
    @PostMapping("/criar")
    UsuarioCadastroResponse cadastrarUsuario(@RequestBody UsuarioCadastroRequest request);

}
