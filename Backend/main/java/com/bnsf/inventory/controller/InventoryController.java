package com.bnsf.inventory.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bnsf.inventory.beans.*;
import com.bnsf.inventory.dao.InventoryDao;
import com.bnsf.inventory.dao.InventoryDaoImpl;
import com.bnsf.inventory.wrapper.InventoryWrapper;

@RestController
@CrossOrigin
public class InventoryController {	
	InventoryDaoImpl imp = new InventoryDaoImpl();	
	//fetch
	@RequestMapping(value = "/inventory/getAllItems", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InventoryItem>> getAllInventory() {
		return new ResponseEntity<>(imp.getAllInventory(), HttpStatus.OK);
	}
	
	//update
	@RequestMapping(value = "/inventory/setItem", method = RequestMethod.POST)
	public ResponseEntity<Void> setItem(@RequestBody InventoryWrapper InventoryItem) {
		imp.updateInventory(InventoryItem);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	//delete
	@RequestMapping(value = "/inventory/deleteItem", method = RequestMethod.POST)
	public ResponseEntity<Void> deleteItem(@RequestBody String pk) {
		imp.deleteInventory(pk);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	//add
	@RequestMapping(value = "/inventory/createItem", method = RequestMethod.POST)
	public ResponseEntity<Void> createItem(@RequestBody InventoryWrapper InventoryItem) {
		imp.createInventory(InventoryItem);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
