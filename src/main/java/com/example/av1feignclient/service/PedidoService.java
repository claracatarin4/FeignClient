package com.example.av1feignclient.service;

import com.example.av1feignclient.dto.PedidoRequest;
import com.example.av1feignclient.dto.PedidoResponse;
import com.example.av1feignclient.entity.Pedido;
import com.example.av1feignclient.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoResponse criarPedido(PedidoRequest request){

        Pedido pedidoNovo = modelMapper.map(request,Pedido.class);
        pedidoNovo.setId(null);
        pedidoNovo.setStatus(1);
        pedidoNovo.setUsuarioId(request.getUsuarioId());
        Pedido pedidoSalvo = pedidoRepository.save(pedidoNovo);
        return modelMapper.map(pedidoSalvo, PedidoResponse.class);
    }

    public List<PedidoResponse> listarPedidosporUsuarioId(Integer usuarioId){

        List<Pedido> pedidos = pedidoRepository.ListarTodos(usuarioId);
        List<PedidoResponse> responses = pedidos.stream()
                .map(pedido -> modelMapper.map(pedido, PedidoResponse.class))
                .collect(Collectors.toList());
        return responses;

    }

}
