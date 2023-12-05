package com.AgendamentosPsi.ProjetoPsicoterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Clinica;

@Repository
public interface ClinicaRepository 
    extends JpaRepository<Clinica, Long>{
    
}
