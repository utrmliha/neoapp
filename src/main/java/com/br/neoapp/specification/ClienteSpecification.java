package com.br.neoapp.specification;

import com.br.neoapp.model.Cliente;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class ClienteSpecification {

    public static Specification<Cliente> nome(String nome){
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("nome"), "%"+nome+"%");
    }

    public static Specification<Cliente> celular(String celular){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("celular"), celular);
    }

    public static Specification<Cliente> email(String email){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("email"), email);
    }

    public static Specification<Cliente> cpf(String cpf){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Cliente> dataDeNascimento(LocalDate dataDeNascimento){
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("dataDeNascimento"), dataDeNascimento);
    }
}
