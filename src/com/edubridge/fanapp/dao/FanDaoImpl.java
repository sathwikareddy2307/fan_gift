package com.edubridge.fanapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.fanapp.model.Fan;
import com.edubridge.fanapp.util.FanUtil;

public class FanDaoImpl implements FanDao   { 
	Connection con = FanUtil.getConnection();

	@Override
	public int addFan(Fan g) {
		String INSERT_QUERY = "insert into fan(brand,colour ,price,rating) values(?,?,?,?)";
		int status = 0;

		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, g.getBrand());
			ps.setString(2, g.getColour());
			ps.setFloat(3, g.getPrice());
			ps.setFloat(4, g.getRating());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
		

	}

	@Override
	public List<Fan> findFan() {
		String SELECT_QUERY = "select * from fan";
		List<Fan> fanList = new ArrayList<>();

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Fan g = new Fan();
				g.setId(rs.getInt("id"));
				g.setBrand(rs.getString("brand"));
				g.setColour(rs.getString("colour"));
				g.setPrice(rs.getFloat("price"));
				g.setRating(rs.getFloat("rating"));
				fanList.add(g);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return fanList;
	
	}

	@Override
	public Fan findFanByBrand(String brand) {
		String SELECT_QUERY ="select  * from fan where brand=?";
		//PreparedStatement;
		 Fan fan = null;
		 PreparedStatement ps;
		 try {
			  ps = con.prepareStatement(SELECT_QUERY);
			 ps.setString(1,brand);
			 ResultSet rs=ps.executeQuery();
			   fan = new Fan();
			 if(rs.next()) {
				fan.setId(rs.getInt("id"));
				fan.setBrand(rs.getString("brand"));
				fan.setColour(rs.getString("colour"));
				fan.setPrice(rs.getFloat("price"));
				fan.setRating(rs.getFloat("rating"));
			 } 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fan;
		
		
	}

	@Override
	public int updateFan(Fan c) {
String UPDATE_QUERY = "UPDATE fan SET brand= ?,colour=?,price=?,rating=? where id=?";
		
        int status=0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1,c.getBrand());
			ps.setString(2,c.getColour());
			ps.setFloat(3,c.getPrice());
			ps.setFloat(4,c.getRating());
			ps.setInt(5,c.getId());
			status= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}

	@Override
	public int deleteFanByBrand(String brand) {
		String DELETE_QUERY ="DELETE  from fan where brand=?";
		int status=0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1,brand);
			status= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;

		
	}

	@Override
	public void deleteAllFan() {
String DELETE_QUERY ="delete from fan";
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			 ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	} 


}
