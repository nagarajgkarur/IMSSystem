package com.iamsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamsystem.domain.Trading;
import com.iamsystem.repository.TradingRepository;

@Service
public class TradingService {


	@Autowired
	TradingRepository tradingRepository;

	public Trading createTrading(Trading trading) {
		return tradingRepository.save(trading);
	}

	public List<Trading> getAllTrading(){
		return tradingRepository.findAll();
	}

	public List<Trading> createBulkTrading(List<Trading> tradings){
		List<Trading> resultList = new ArrayList<>();
		tradings.forEach(e->{
			resultList.add(tradingRepository.save(e));
		});
		return resultList;
	}

}
