package com.iamsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamsystem.domain.Trading;
import com.iamsystem.service.TradingService;

@RestController
@RequestMapping("/trading")
public class TradingController {

	@Autowired
	TradingService tradingService;

	@PostMapping("/")
	public Trading createTrading(@RequestBody Trading trading) {
		return tradingService.createTrading(trading);
	}

	@GetMapping("/")
	public List<Trading> getAllTrading(){
		return tradingService.getAllTrading();
	}

	@PostMapping("/bulk/")
	public List<Trading> createBulkTrading(@RequestBody List<Trading> tradings){
		return tradingService.createBulkTrading(tradings);
	}
}
