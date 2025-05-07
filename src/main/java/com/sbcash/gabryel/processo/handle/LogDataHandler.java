package com.sbcash.gabryel.processo.handle;

import com.sbcash.gabryel.processo.entity.nosql.LogData;
import com.sbcash.gabryel.processo.service.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class LogDataHandler {

    private final LogDataService logService;

    @Autowired
    public LogDataHandler(LogDataService logService) {
        this.logService = logService;
    }

    public Mono<ServerResponse> getAllLogs(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(logService.findAll(), LogData.class);
    }
}
