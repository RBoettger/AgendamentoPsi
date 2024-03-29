package com.AgendamentosPsi.ProjetoPsicoterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Servico;

@Repository
public interface ServicoRepository 
    extends JpaRepository<Servico, Long>{
    
}
