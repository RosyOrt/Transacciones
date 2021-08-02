package com.example.transactionClient.structureRequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
	
	private String type;
	private String code;
	private String location;
	private String moreInfo;

}
