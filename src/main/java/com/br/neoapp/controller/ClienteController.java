package com.br.neoapp.controller;

import com.br.neoapp.controller.dto.ClienteDto;
import com.br.neoapp.controller.form.ClienteForm;
import com.br.neoapp.controller.form.ClienteParamsForm;
import com.br.neoapp.controller.service.ClienteService;
import com.br.neoapp.validation.Celular;
import com.br.neoapp.validation.Cpf;
import com.br.neoapp.validation.DataDeNascimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> salvar(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
        ClienteDto clienteSalvo = clienteService.salvar(clienteForm);

        URI uri = uriBuilder.path("/clientes").buildAndExpand(clienteSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteSalvo);
    }

    @GetMapping
    public Page<ClienteDto> listar(ClienteParamsForm clienteParamsForm,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable) {

        return clienteService.listar(clienteParamsForm, pageable);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> atualizar(@PathVariable(value = "id", required = true) Long id, @RequestBody @Valid ClienteParamsForm clienteParamsForm) {
        return clienteService.atualizar(id, clienteParamsForm)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscar(@PathVariable(value = "id", required = true) Long id) {
        return clienteService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id", required = true) Long id) {
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
