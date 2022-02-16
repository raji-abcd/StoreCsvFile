package com.te.storedata.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.storedata.pojo.StoreResponse;

@ControllerAdvice
public class Custom {

	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<StoreResponse> customExcep(CustomException exception) {
		return new ResponseEntity<>(new StoreResponse(false,exception.getMessage(),null,null),HttpStatus.NOT_FOUND);
	}

}
