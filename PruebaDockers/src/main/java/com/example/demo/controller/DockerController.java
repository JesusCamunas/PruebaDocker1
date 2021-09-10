package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class DockerController {
    @GetMapping("/")
    @ResponseBody
    public String welcomeWithParamName() {
    	String textoAMostrar="";
    	textoAMostrar="Prueba Proyecto docker JAVA Tutorial Minsait";
        return textoAMostrar;
    }
}
