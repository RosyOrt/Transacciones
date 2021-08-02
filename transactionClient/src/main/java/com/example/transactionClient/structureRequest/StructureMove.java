package com.example.transactionClient.structureRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StructureMove {

	@Id
	@NotNull(message = "customerId no puede ir nulo")
	int customerId;	

	@NotEmpty(message = "transactionDateStart no puede ir vacio")
	@NotNull(message = "transactionDateStart no puede ir nulo")
	String transactionDateStart;	

	@NotEmpty(message = "transactionDateEnd no puede ir vacio")
	@NotNull(message = "transactionDateEnd no puede ir nulo")
	String transactionDateEnd;
}
