package com.AgendamentosPsi.ProjetoPsicoterapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Clinica;
import com.AgendamentosPsi.ProjetoPsicoterapia.repository.ClinicaRepository;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.ClinicaService;

@Service
public class ClinicaServiceImpl implements ClinicaService{
    @Autowired
    private ClinicaRepository repository;
    @Override
    public List<Clinica> getAll() {
        return repository.findAll();
    }
    @Override
    public void save(Clinica clinica) {
        repository.save(clinica);
    }
    @Override
    public void delete(Clinica clinica) {
        repository.delete(clinica);
    }
    
}
