package structureRequest;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StructureTran {
		
	
	@NotNull(message = "accountId no puede ir nulo")
	int accountId;
	
	@NotNull(message = "branchId no puede ir nulo")
	int branchId;
	
	@NotEmpty(message = "transactionDateStart no puede ir vacio")
	@NotNull(message = "transactionDateStart no puede ir nulo")
	String transactionDateStart;
	
	@NotEmpty(message = "transactionDateEnd no puede ir vacio")
	@NotNull(message = "transactionDateEnd no puede ir nulo")
	String transactionDateEnd;
	
}
