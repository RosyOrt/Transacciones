package com.example.transactionsclientFeign.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import structureRequest.StructureMove;
import structureRequest.StructureTran;

@RestController
@EnableFeignClients
public class RequestController {

	@Autowired
	private FeignInterface feignInterface;

	@PostMapping(path = "/transacciones")	
	public String transFeing (@Valid @RequestBody StructureTran structure) {

		String acoId = (structure.getAccountId()+"").substring(0,3);
		String branId = (structure.getBranchId() + "").substring(0,3);
		
		int customerId = Integer.parseInt(acoId + branId);
		StructureMove  structureMove = new StructureMove();
		
	    structureMove.setCustomerId(customerId);
		structureMove.setTransactionDateStart(structure.getTransactionDateStart());
		structureMove.setTransactionDateEnd(structure.getTransactionDateEnd());
		
		String reponse = feignInterface.structureTran(structureMove);

		return reponse;
	}
}
