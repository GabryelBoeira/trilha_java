package com.sbcash.gabryel.processo.repository.nosql;

import com.sbcash.gabryel.processo.entity.nosql.LogData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDataRepository extends ReactiveMongoRepository<LogData, String> {
}