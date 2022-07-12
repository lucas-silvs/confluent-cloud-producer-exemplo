package com.lucassilvs.confluentcloud.confluentcloudusecases.service.impl;

import com.lucassilvs.confluentcloud.confluentcloudusecases.gateway.KafkaPost;
import com.lucasSilvs.confluentCloud.confluentcloudusecases.kafka.UsuarioDadosTesteAvro;
import com.lucassilvs.confluentcloud.confluentcloudusecases.models.request.UsuarioDadosContract;
import com.lucassilvs.confluentcloud.confluentcloudusecases.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private final KafkaPost kafkaPost;

    @Autowired
    public UsuarioServiceImpl(KafkaPost kafkaPost) {
        this.kafkaPost = kafkaPost;
    }

    @Override
    public void postarNoTopico(UsuarioDadosContract dadosContract) {
        UsuarioDadosTesteAvro dadosTesteAvro = criarAvro(dadosContract);
        kafkaPost.sendMessage(dadosTesteAvro);
    }

    private UsuarioDadosTesteAvro criarAvro(UsuarioDadosContract dadosContract) {
        return UsuarioDadosTesteAvro.newBuilder()
                .setId(dadosContract.getId())
                .setNome(dadosContract.getNome())
                .setSaldo(dadosContract.getSaldo())
                .build();
    }
}
