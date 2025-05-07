package com.sbcash.gabryel.processo.service;

import com.sbcash.gabryel.processo.entity.nosql.LogData;
import com.sbcash.gabryel.processo.repository.nosql.LogDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class LogDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogDataService.class);

    private final LogDataRepository logDataRepository;

    @Autowired
    public LogDataService(LogDataRepository logDataRepository) {
        this.logDataRepository = logDataRepository;
    }

    public Flux<LogData> findAll() {
        return logDataRepository.findAll();
    }

}
