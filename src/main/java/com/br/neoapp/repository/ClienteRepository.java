package com.br.neoapp.repository;

import com.br.neoapp.model.Cliente;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

}
