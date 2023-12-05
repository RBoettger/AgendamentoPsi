package com.AgendamentosPsi.ProjetoPsicoterapia.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Agendamento;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.AgendamentoService;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.ClienteService;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.ClinicaService;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.ServicoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {
	
	
	@Autowired
    private AgendamentoService service;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ServicoService servicoService;
    @Autowired
    private ClinicaService clinicaService;
    @GetMapping
    public ModelAndView index(){

        var listaAgendamentos = service.getAll();
        
        return new ModelAndView("agendamento/index","listaAgendamentos",listaAgendamentos);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        HashMap<String,Object> dados = new HashMap<>();
        var novoAgendamento = new Agendamento ();
        var listaCliente = clienteService.getAll();
        var listaServico = servicoService.getAll();
        var listaClinica = clinicaService.getAll();
        
        dados.put("agendamento",novoAgendamento);
        dados.put("listaCliente",listaCliente);
        dados.put("listaServico",listaServico);
        dados.put("listaClinica",listaClinica);

        return new ModelAndView("agendamento/form", dados);
    }
    @PostMapping
    public ModelAndView save(@Valid Agendamento agendamento, 
                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> dados = new HashMap<>();
            var listaCliente = clienteService.getAll();
            var listaServico = servicoService.getAll();
            var listaClinica = clinicaService.getAll();
            dados.put("agendamento",agendamento);
            dados.put("listaCliente",listaCliente);
            dados.put("listaServico",listaServico);
            dados.put("listaClinica",listaClinica);
            return new ModelAndView("agendamento/form", dados);
        }
        service.save(agendamento);
        return new ModelAndView("redirect:agendamentos");

    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Agendamento agendamento){

        HashMap<String,Object> dados = new HashMap<>();
        var listaCliente = clienteService.getAll();
        var listaClinica = clinicaService.getAll();
        var listaServico = servicoService.getAll();
        dados.put("agendamento",agendamento);
        dados.put("listaCliente",listaCliente);
        dados.put("listaServico",listaServico);
        dados.put("listaClinica",listaClinica);

        return new ModelAndView("agendamento/form",dados);
    }


    @GetMapping("/remover/{id}")
    public ModelAndView remover(
            @PathVariable("id") Agendamento agendamento){
        service.delete(agendamento);
        return new ModelAndView("redirect:/agendamentos");
    }

}
