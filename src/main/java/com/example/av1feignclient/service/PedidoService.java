package com.example.av1feignclient.service;

import com.example.av1feignclient.dto.PedidoRequest;
import com.example.av1feignclient.dto.PedidoResponse;
import com.example.av1feignclient.dto.UsuarioCadastroResponse;
import com.example.av1feignclient.entity.Pedido;
import com.example.av1feignclient.interfaces.UsuarioClient;
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
    private UsuarioClient usuarioClient;

    public PedidoResponse criarPedido(PedidoRequest request){
        Pedido pedidoNovo = new Pedido();
        UsuarioCadastroResponse responseUsuario = usuarioClient.cadastrarUsuario(request.getUsuario());
        pedidoNovo.setId(null);
        pedidoNovo.setUsuarioId(responseUsuario.getId());
        pedidoNovo.setStatus(request.getStatus());
        pedidoNovo.setData(request.getData());
        pedidoNovo.setValor_total(request.getValorTotal());
        Pedido pedidoSalvo = pedidoRepository.save(pedidoNovo);
        return modelMapper.map(pedidoSalvo,PedidoResponse.class);
    }
    public List<PedidoResponse> listarPedidosPorUsuarioId(Integer usuarioId) {
        List<Pedido> pedidos = pedidoRepository.retornarPedidoPorId(usuarioId);
        return pedidos.stream()
                .map(pedido -> modelMapper.map(pedido, PedidoResponse.class))
                .collect(Collectors.toList());
    }

}
