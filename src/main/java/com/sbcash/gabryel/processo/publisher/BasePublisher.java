package com.sbcash.gabryel.processo.publisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public abstract class BasePublisher<T> {

    private static final Logger LOG = LoggerFactory.getLogger(BasePublisher.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    protected BasePublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public abstract void publisher(T clazz);

    /**
     * Sends a message to a specified Kafka topic asynchronously.
     *
     * @param message the message content to be sent
     * @param topic the Kafka topic to which the message will be sent
     *
     * This method utilizes the KafkaTemplate to send a message with a unique key to a given topic.
     * It logs the success and offset of the message if sent successfully, or logs an error if the delivery fails.
     */
    protected void send(final String message, final String topic) {

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, UUID.randomUUID().toString(), message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                LOG.info(" Message {} was sent successfully! Offset : {}", message, result.getRecordMetadata().offset());
            } else {
                LOG.warn("Fail on delivering message : {} because {}", message, ex.getMessage());
            }
        });
    }

}