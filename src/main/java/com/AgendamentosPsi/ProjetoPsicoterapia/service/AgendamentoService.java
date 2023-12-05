package com.AgendamentosPsi.ProjetoPsicoterapia.service;

import java.util.List;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Agendamento;

public interface AgendamentoService {
    List<Agendamento> getAll();
    
    void save(Agendamento agendamento);

    void delete(Agendamento agendamento);

}
