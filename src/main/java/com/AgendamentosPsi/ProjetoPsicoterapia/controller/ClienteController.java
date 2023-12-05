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

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Cliente;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.ClienteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ModelAndView index(){
        var listaClientes = service.getAll();      
        return new ModelAndView("cliente/index","listaClientes",listaClientes);
    }
    @GetMapping("/novo")
    public ModelAndView novo(){
        HashMap<String,Object> dados = new HashMap<>();
        var novoCliente = new Cliente(); 
        dados.put("cliente",novoCliente);
        return new ModelAndView("cliente/form", dados);
    }
    @PostMapping
    public ModelAndView save(@Valid Cliente cliente, 
                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("cliente",cliente);
            return new ModelAndView("cliente/form", dados);
        }
        service.save(cliente);
        return new ModelAndView("redirect:clientes");

    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Cliente cliente){

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente",cliente);
        return new ModelAndView("cliente/form",dados);
    }
    @GetMapping("/remover/{id}")
    public ModelAndView remover(
            @PathVariable("id") Cliente cliente){
        service.delete(cliente);
        return new ModelAndView("redirect:/clientes");
    }

}
