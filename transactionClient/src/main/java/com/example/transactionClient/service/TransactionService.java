package com.example.transactionClient.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.transactionClient.repository.TransactionRepository;
import com.example.transactionClient.structureRequest.Transaction;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository repository; 
	
	@Autowired
	MongoTemplate template;
	
	public List<Transaction> getTransactions(int customerId, LocalDateTime dStart, LocalDateTime dEnd){
		
		List<Transaction> myList = null;//repository.findAllByCustomerIdAndDateBetween(customerId, dStart, dEnd);
		System.out.println(repository.findById(customerId).isPresent()? repository.findById(customerId).get(): "no encontrado");
//		template.find(Query.query(Criteria.where("customerId").is(344376)), Transaction.class, "Transactions");
		return myList;
	}

}
