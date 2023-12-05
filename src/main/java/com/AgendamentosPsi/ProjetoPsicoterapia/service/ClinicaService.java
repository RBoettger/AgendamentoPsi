package com.AgendamentosPsi.ProjetoPsicoterapia.service;

import java.util.List;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Clinica;

public interface ClinicaService {
    List<Clinica> getAll();
    
    void save(Clinica clinica);

    void delete(Clinica clinica);
}
