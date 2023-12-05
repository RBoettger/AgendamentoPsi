package com.AgendamentosPsi.ProjetoPsicoterapia.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = 
        GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, 
        length = 1000)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendamento")
    private List<Cliente> clientes;
    @Temporal(TemporalType.DATE)
    private Date dataAtendimento;

    @ManyToOne(cascade = {CascadeType.MERGE, 
                        CascadeType.REFRESH})
    private Servico servico;
    
    @ManyToOne(cascade = {CascadeType.MERGE, 
            CascadeType.REFRESH})
    
    private Clinica clinica;
    
    public Clinica getClinica() {
        return clinica;
    }
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public Date getDataAtendimento() {
        return dataAtendimento;
    }
    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
    
}
