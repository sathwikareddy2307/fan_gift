package com.edubridge.fanapp.service;

import java.util.List;

import com.edubridge.fanapp.dao.FanDao;
import com.edubridge.fanapp.dao.FanDaoImpl;
import com.edubridge.fanapp.model.Fan;

public class FanServiceImpl implements FanService{
	FanDao dao = new FanDaoImpl();

	@Override
	public int addFan(Fan g) {
		
		return dao.addFan(g);
	}

	@Override
	public List<Fan> findFan() {
		
		return dao.findFan();
	}

	@Override
	public Fan findFanByBrand(String brand) {
		
		return dao.findFanByBrand(brand);
	}

	@Override
	public int updateFan(Fan c) {
		
		return dao.updateFan(c);
	}

	@Override
	public int deleteFanByBrand(String brand) {
		
		return dao.deleteFanByBrand(brand);
				}

	@Override
	public void deleteAllFan() {
		
        dao.deleteAllFan();
	}
	

}
