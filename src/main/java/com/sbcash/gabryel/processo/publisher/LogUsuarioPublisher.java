package com.sbcash.gabryel.processo.publisher;

import com.google.gson.Gson;
import com.sbcash.gabryel.processo.dto.UsuarioDTO;
import com.sbcash.gabryel.processo.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class LogUsuarioPublisher extends BasePublisher<UsuarioDTO> {

    private static final Logger LOG = LoggerFactory.getLogger(LogUsuarioPublisher.class);

    public LogUsuarioPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        super(kafkaTemplate);
    }

    @Override
    public void publisher(UsuarioDTO usuarioDTO) {
        try {
            Gson gson = GsonUtils.getGson();
            String message = Base64.getEncoder().encodeToString(gson.toJson(usuarioDTO).getBytes());
            send(message, "CRUD_NEW_USER");
        } catch (Exception e) {
            LOG.error("LogUsuarioPublisher -> " + e.getMessage(), e.getCause());
        }
    }
}
