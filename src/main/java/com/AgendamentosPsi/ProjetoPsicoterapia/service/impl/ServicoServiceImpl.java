package com.AgendamentosPsi.ProjetoPsicoterapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Servico;
import com.AgendamentosPsi.ProjetoPsicoterapia.repository.ServicoRepository;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService{
    @Autowired
    private ServicoRepository repository;
    @Override
    public List<Servico> getAll() {
        return repository.findAll();
    }
    
}
