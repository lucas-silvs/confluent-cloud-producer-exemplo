package com.lucassilvs.confluentcloud.confluentcloudusecases.controller;

import com.lucassilvs.confluentcloud.confluentcloudusecases.models.request.UsuarioDadosContract;
import org.springframework.http.ResponseEntity;

public interface UsuarioController {

    ResponseEntity<Void> postarNoTopicoKafka(UsuarioDadosContract usuarioDadosContract);
}
