package com.AgendamentosPsi.ProjetoPsicoterapia.service;

import java.util.List;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Cliente;

public interface ClienteService {
    List<Cliente> getAll();
    
    void save(Cliente cliente);

    void delete(Cliente cliente);

}
