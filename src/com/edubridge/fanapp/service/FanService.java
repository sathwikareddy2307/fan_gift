package com.edubridge.fanapp.service;

import java.util.List;

import com.edubridge.fanapp.model.Fan;

public interface FanService {
	int addFan(Fan g);
	List<Fan> findFan();
	Fan findFanByBrand(String brand);
	int updateFan(Fan c);
	int deleteFanByBrand(String brand);
	void deleteAllFan();
	

}
