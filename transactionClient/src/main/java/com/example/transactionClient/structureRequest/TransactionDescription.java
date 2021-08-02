package com.example.transactionClient.structureRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class TransactionDescription {
	@Id
	@Column(name = "transactionType")
	private String transactionType;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "amount")
	private  double amount;

}
