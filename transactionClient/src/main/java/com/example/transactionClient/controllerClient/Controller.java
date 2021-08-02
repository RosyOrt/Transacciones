package com.example.transactionClient.controllerClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactionClient.service.TransactionService;
import com.example.transactionClient.structureRequest.StructureMove;
import com.example.transactionClient.structureRequest.Transaction;

@RestController
@RequestMapping("/controller-provider")
public class Controller {

	@Value("${server.port}")
	private int port;
	@Autowired 
	TransactionService service;

	@PostMapping("/structureTran")
	public String structureTran(@Valid @RequestBody StructureMove structureMov) {
		
		 String dStart = structureMov.getTransactionDateStart() + " 00:00";
		 String dEnd = structureMov.getTransactionDateEnd() + " 23:59";
		 
		 DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		 LocalDateTime dateTimeS = LocalDateTime.parse(dStart, formater);
		 LocalDateTime dateTimeE = LocalDateTime.parse(dEnd, formater);

		List<Transaction> transactionList = service.getTransactions(structureMov.getCustomerId(), dateTimeS, dateTimeE );
		
		
		return "The transaction was successful: " + transactionList.toString();
	}
	
	
	
		
	
}