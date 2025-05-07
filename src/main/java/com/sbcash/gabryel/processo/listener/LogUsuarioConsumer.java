package com.sbcash.gabryel.processo.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sbcash.gabryel.processo.dto.UsuarioDTO;
import com.sbcash.gabryel.processo.entity.nosql.LogData;
import com.sbcash.gabryel.processo.repository.nosql.LogDataRepository;
import com.sbcash.gabryel.processo.utils.GsonUtils;
import jakarta.transaction.Transactional;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class LogUsuarioConsumer {

    private final LogDataRepository logDataRepository;

    @Autowired
    public LogUsuarioConsumer(LogDataRepository logDataRepository) {
        this.logDataRepository = logDataRepository;
    }

    @Transactional
    @KafkaListener(topics = "CRUD_NEW_USER", groupId = "group-id-crud-usuario", containerFactory = "kafkaListenerContainerFactory",
            autoStartup = "${crud.kafka.listen.auto.start}")
    public void usuarioConsumer(final ConsumerRecord<String, String> record) throws IOException {
        Gson gson = GsonUtils.getGson();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(record.value());
        UsuarioDTO usuario = gson.fromJson(new String(bytes, StandardCharsets.UTF_8), UsuarioDTO.class);
        logDataRepository.save(new LogData(UUID.randomUUID().toString(), LocalDateTime.now(), usuario)).subscribe();
    }
}