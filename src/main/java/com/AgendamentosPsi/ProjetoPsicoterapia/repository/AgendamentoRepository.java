package com.AgendamentosPsi.ProjetoPsicoterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Agendamento;

@Repository
public interface AgendamentoRepository 
        extends JpaRepository<Agendamento,Long> {
}
