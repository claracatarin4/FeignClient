package com.example.av1feignclient.repository;


import com.example.av1feignclient.dto.PedidoRequest;
import com.example.av1feignclient.dto.PedidoResponse;
import com.example.av1feignclient.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
    @PostMapping("/api/pedido/criar")
    PedidoResponse salvarPedido(PedidoRequest request);
    @Query("SELECT p FROM Pedido p WHERE p.usuarioId = :usuarioId")
    List<Pedido> ListarTodos(@Param("usuarioId") Integer usuarioId);

}
