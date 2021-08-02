package com.example.transactionsclientFeign.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import structureRequest.StructureMove;
import structureRequest.StructureTran;

@FeignClient("RETRIEVE-CURRENT-TRANSACTION")
public interface FeignInterface {
	@PostMapping("/controller-provider/structureTran")
	String structureTran(@RequestBody StructureMove structureMove);

}
