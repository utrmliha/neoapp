package com.br.neoapp.controller.service;

import com.br.neoapp.controller.dto.ClienteDto;
import com.br.neoapp.controller.form.ClienteForm;
import com.br.neoapp.controller.form.ClienteParamsForm;
import com.br.neoapp.model.Cliente;
import com.br.neoapp.repository.ClienteRepository;
import com.br.neoapp.specification.ClienteSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static com.br.neoapp.util.StringsUtils.isNullOrEmptyOrBlank;

@Service
public class ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDto salvar(ClienteForm clienteForm) {
        Cliente cliente = clienteForm.toCliente();

        cliente.setDataDeCriacao(LocalDateTime.now());
        cliente.setDataDeAtualizacao(cliente.getDataDeCriacao());

        return new ClienteDto(clienteRepository.save(cliente));
    }

    public Page<ClienteDto> listar(ClienteParamsForm clienteParamsForm, Pageable pageable) {
        return clienteRepository.findAll(Specification.where(
            ClienteSpecification.nome(clienteParamsForm.getNome())
                .and(ClienteSpecification.celular(clienteParamsForm.getCelular()))
                .and(ClienteSpecification.email(clienteParamsForm.getEmail()))
                .and(ClienteSpecification.cpf(clienteParamsForm.getCpf()))
                .and(ClienteSpecification.dataDeNascimento(clienteParamsForm.getDataDeNascimento()))
        ), pageable).map(ClienteDto::new);
    }

    public Optional<ClienteDto> atualizar(Long id, ClienteParamsForm clienteParamsForm) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    if(!isNullOrEmptyOrBlank(clienteParamsForm.getNome()))
                        cliente.setNome(clienteParamsForm.getNome());
                    if(!isNullOrEmptyOrBlank(clienteParamsForm.getCelular()))
                        cliente.setCelular(clienteParamsForm.getCelular());
                    if(!isNullOrEmptyOrBlank(clienteParamsForm.getEmail()))
                        cliente.setEmail(clienteParamsForm.getEmail());
                    if(!isNullOrEmptyOrBlank(clienteParamsForm.getCpf()))
                        cliente.setCpf(clienteParamsForm.getCpf());
                    if(clienteParamsForm.getDataDeNascimento() != null)
                    cliente.setDataDeNascimento(clienteParamsForm.getDataDeNascimento());

                    cliente.setDataDeAtualizacao(LocalDateTime.now());

                    return Optional.of(new ClienteDto(cliente));
                })
                .orElse(Optional.empty());
    }

    public Optional<ClienteDto> buscar(Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> Optional.of(new ClienteDto(cliente)))
                .orElse(Optional.empty());
    }

    public void deletar(Long id) {
        clienteRepository.findById(id).ifPresent(clienteRepository::delete);
    }
}
