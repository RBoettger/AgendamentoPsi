package com.AgendamentosPsi.ProjetoPsicoterapia.controller;

// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
// @PreAuthorize("hasAuthority('APPROLE_Admin')")
public class HomeController {
    @GetMapping
    @ResponseBody
    public String index(){
        return "Mãe eu nao acredito";
    }
}
