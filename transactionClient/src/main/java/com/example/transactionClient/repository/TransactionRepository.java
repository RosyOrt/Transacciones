package com.example.transactionClient.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.example.transactionClient.structureRequest.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {
	
 List<Transaction> findAllByCustomerIdAndDateBetween(int customerId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
 List<Transaction> findAllByCustomerId(int customerId);
 List<Transaction> findByCustomerId(int customerId);


}
