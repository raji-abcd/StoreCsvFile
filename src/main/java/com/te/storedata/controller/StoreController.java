package com.te.storedata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.storedata.pojo.Store;
import com.te.storedata.pojo.StoreResponse;
import com.te.storedata.service.StoreService;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
	
	@Autowired
	private StoreService service;

	@GetMapping("/fetch/{storeId}")
	public ResponseEntity<StoreResponse> getStoreById(@PathVariable String storeId) {
		Store storeById = service.getStoreById(storeId);
		if(storeById!=null) {
			System.out.println("jjjjjj"+storeById);
			return new ResponseEntity<>(new StoreResponse(true, "data fetch successfully", storeById,null),HttpStatus.OK);
		}else
			return new ResponseEntity<>(new StoreResponse(false, "data not found", storeById,null),HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/sortedfetch/{field}")
	public ResponseEntity<StoreResponse>getStoresByField(@PathVariable String field) {
		List<Store> storesByCity = service.getStoresByCity(field);
		if(!storesByCity.isEmpty()) {
			return new ResponseEntity<>(new StoreResponse(true, "data fetch successfully",null,storesByCity),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(new StoreResponse(false,"Data not found",null,storesByCity),HttpStatus.NOT_FOUND);
		}
	}

}
