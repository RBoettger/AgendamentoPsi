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

import com.AgendamentosPsi.ProjetoPsicoterapia.entity.Clinica;
import com.AgendamentosPsi.ProjetoPsicoterapia.service.ClinicaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/clinicas")
public class ClinicaController {

    @Autowired
    private ClinicaService service;
    @GetMapping
    public ModelAndView index(){

        var listaClinicas = service.getAll();
        
        return new ModelAndView("clinica/index","listaClinicas",listaClinicas);
    }
    
    @GetMapping("/novo")
    public ModelAndView novo(){
        HashMap<String,Object> dados = new HashMap<>();
        var novaClinica = new Clinica();        
        dados.put("clinica",novaClinica);
 
        return new ModelAndView("clinica/form", dados);
    }
    
    @PostMapping
    public ModelAndView save(@Valid Clinica clinica, 
                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> dados = new HashMap<>();
            dados.put("clinica",clinica);
            return new ModelAndView("clinica/form", dados);
        }
        service.save(clinica);
        return new ModelAndView("redirect:clinicas");

    }
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Clinica clinica){

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("clinica",clinica);

        return new ModelAndView("clinica/form",dados);
    }

    @GetMapping("/remover/{id}")
    public ModelAndView remover(
            @PathVariable("id") Clinica clinica){
        service.delete(clinica);
        return new ModelAndView("redirect:/clinicas");
    }

}
