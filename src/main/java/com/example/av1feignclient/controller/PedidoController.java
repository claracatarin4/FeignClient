package com.example.av1feignclient.controller;

import com.example.av1feignclient.dto.PedidoRequest;
import com.example.av1feignclient.dto.PedidoResponse;
import com.example.av1feignclient.entity.Pedido;
import com.example.av1feignclient.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.criarPedido(request));
    }

    @GetMapping("/por-usuario")
    public ResponseEntity<List<PedidoResponse>> listarPedidosPorUsuario(@RequestParam("usuarioId") Integer usuarioId) {
        return ResponseEntity.ok(pedidoService.listarPedidosPorUsuarioId(usuarioId));
    }

}
