package com.lucassilvs.confluentcloud.confluentcloudusecases.controller.impl;

import com.lucassilvs.confluentcloud.confluentcloudusecases.controller.UsuarioController;
import com.lucassilvs.confluentcloud.confluentcloudusecases.models.request.UsuarioDadosContract;
import com.lucassilvs.confluentcloud.confluentcloudusecases.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> postarNoTopicoKafka( @RequestBody @Validated UsuarioDadosContract usuarioDadosContract) {
        usuarioService.postarNoTopico(usuarioDadosContract);
        return ResponseEntity.ok().build();
    }
}
