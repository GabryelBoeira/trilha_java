package com.sbcash.gabryel.processo.router;

import com.sbcash.gabryel.processo.entity.nosql.LogData;
import com.sbcash.gabryel.processo.handle.LogDataHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class LogDataRouter {

    @Bean
    @RouterOperation(path = "/logs",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET,
            beanClass = LogDataHandler.class,
            beanMethod = "getAllLogs",
            operation = @Operation(operationId = "getAllLogs",
                    tags = { "Log Data Functional Controller" },
                    summary = "Get all logs in a reactive way :)",
                    responses = {
                            @ApiResponse(responseCode = "200", description = "successful operation",
                                    content = @Content(schema = @Schema(implementation = LogData.class))),
                            @ApiResponse(responseCode = "404", description = "error not found")
                    }
            ))
    public RouterFunction<ServerResponse> getLogs(LogDataHandler logHandler) {
        return RouterFunctions
                .route(GET("/logs")
                        .and(accept(MediaType.APPLICATION_JSON)), logHandler::getAllLogs);
    }

}
