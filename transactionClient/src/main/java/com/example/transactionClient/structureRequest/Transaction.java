package com.example.transactionClient.structureRequest;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection="Transactions")
@Data
@AllArgsConstructor
public class Transaction {
	
	@Id
	ObjectId objectId;
	
	@Column(name = "customerId")
	private int customerId;
	
	@Column(name = "date")
	private String date;
	
	@Field(name = "transactionDescription")
	private TransactionDescription transactionDescription;
}
