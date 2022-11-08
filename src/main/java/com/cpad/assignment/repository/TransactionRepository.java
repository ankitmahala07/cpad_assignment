package com.cpad.assignment.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.cpad.assignment.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends ArangoRepository<Transaction,String> {

    @Query("FOR doc IN #collection \n"+
            "FILTER doc.userId==@userId \n" +
            "SORT doc.createdAt DESC \n"+
            "LIMIT @offset, @size \n"+
            "return doc"
    )
    List<Transaction> findByUserIdAndPageAndSize(String userId, int offset, int size);

}
