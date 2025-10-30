package com.example.av1feignclient.service;

import com.example.av1feignclient.dto.PedidoRequest;
import com.example.av1feignclient.dto.PedidoResponse;
import com.example.av1feignclient.dto.UsuarioCadastroResponse;
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
    @Autowired
    private UsuarioService usuarioService; // Injeta o serviço que busca o usuário

    public PedidoResponse criarPedido(PedidoRequest request) {
        // 1. Busca o usuário pelo nome para obter o ID
        UsuarioCadastroResponse usuario = usuarioService.buscarUsuarioPorNome(request.getNomeUsuario());

        // 2. Se encontrou, prossegue com a criação do pedido
        Pedido pedidoNovo = modelMapper.map(request, Pedido.class);
        pedidoNovo.setUsuarioId(usuario.getId()); // Define o ID do usuário encontrado
        pedidoNovo.setStatus(1);

        Pedido pedidoSalvo = pedidoRepository.save(pedidoNovo);
        return modelMapper.map(pedidoSalvo, PedidoResponse.class);
    }

    public List<PedidoResponse> listarPedidosPorUsuarioId(Integer usuarioId) {
        List<Pedido> pedidos = pedidoRepository.findByUsuarioId(usuarioId);
        return pedidos.stream()
                .map(pedido -> modelMapper.map(pedido, PedidoResponse.class))
                .collect(Collectors.toList());
    }

}
