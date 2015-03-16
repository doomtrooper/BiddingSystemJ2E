package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sapient.exceptions.InsertItemException;
import com.sapient.exceptions.NoItemFoundException;
import com.sapient.vo.Item;

public class ItemDao implements ItemImplementation {
	Connection conn=null;
	@Override
	public void insertItem(Item i) throws InsertItemException {
		conn=AbsDao.getConnection();
		try {
			PreparedStatement insertItem=conn.prepareStatement(Queries.insertItem);
			insertItem.setInt(1, i.getUserId());
			insertItem.setString(2, i.getItemName());
			insertItem.setString(3, i.getItemDescription());
			insertItem.setString(4, i.getItemCategory());
			int rs=insertItem.executeUpdate();
			if(rs==0) throw new InsertItemException("item Not Inserted :/");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}
	public int getItemId(String itemName) throws NoItemFoundException {
		conn=AbsDao.getConnection();
		int flag=0;
		try {
			PreparedStatement getItemInfo=conn.prepareStatement(Queries.getItemInfo);
			getItemInfo.setString(1, itemName);
			ResultSet rs=getItemInfo.executeQuery();
			if(!rs.next()) throw new NoItemFoundException("Item Not Found :( :(");
			flag=rs.getInt("itemid");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return flag;
	}

}
