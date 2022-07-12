package com.lucassilvs.confluentcloud.confluentcloudusecases.service;

import com.lucassilvs.confluentcloud.confluentcloudusecases.models.request.UsuarioDadosContract;

public interface UsuarioService {

    void postarNoTopico(UsuarioDadosContract dadosContract);


}
