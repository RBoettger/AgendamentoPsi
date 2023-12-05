package com.AgendamentosPsi.ProjetoPsicoterapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Agendamento;
import com.AgendamentosPsi.ProjetoPsicoterapia.repository.AgendamentoRepository;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.AgendamentoService;


@Service
public class AgendamentoServiceImpl implements AgendamentoService{

    @Autowired
    private AgendamentoRepository repository;

    @Override
    public List<Agendamento> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Agendamento agendamento) {
        repository.save(agendamento);
    }
    @Override
    public void delete(Agendamento agendamento) {
        repository.delete(agendamento);
    }
}
