package com.lucassilvs.confluentcloud.confluentcloudusecases.gateway;

import com.lucasSilvs.confluentCloud.confluentcloudusecases.kafka.UsuarioDadosTesteAvro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;


@Component
public class KafkaPost {


    public static final String NOME_TOPICO = "topico_teste";

    private static final Logger log = Logger.getGlobal();
    private final KafkaTemplate<String, UsuarioDadosTesteAvro> kafkaTemplate;

    @Autowired
    KafkaPost(KafkaTemplate<String, UsuarioDadosTesteAvro> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UsuarioDadosTesteAvro message) {
        try {
            kafkaTemplate.send(NOME_TOPICO, message).get(2, TimeUnit.SECONDS);
            log.info("Mensagem postada no topico:  " + NOME_TOPICO);
        } catch (ExecutionException | TimeoutException e) {
            log.info("Erro ao enviar mensagem para o tópico: " + e);

        } catch (InterruptedException e) {
            log.info("Erro ao enviar mensagem para o tópico: " + e);
            Thread.currentThread().interrupt();
        }
    }
}

