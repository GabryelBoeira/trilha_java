package com.sbcash.gabryel.processo.publisher;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public abstract class BasePublisher<T> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    protected BasePublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public abstract void publisher(T clazz);

    protected void send(final String message, final String topic) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, UUID.randomUUID().toString(), message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Message : " + message + " was sent successfully! Offset : " + result.getRecordMetadata().offset());
            } else {
                System.out.println("Fail on delivering message : " + message + " because " + ex.getMessage());
            }
        });
    }

}