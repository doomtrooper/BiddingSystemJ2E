package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sapient.exceptions.InsertAuctionException;
import com.sapient.exceptions.NoAuctionFoundException;
import com.sapient.exceptions.NoItemFoundException;
import com.sapient.vo.Auction;
import com.sapient.vo.Item;
import com.sapient.vo.User;

public class AuctionDao implements AuctionImplementation {
	Connection conn = null;

	public void insertAuction(Auction a) throws InsertAuctionException {
		conn = AbsDao.getConnection();
		try {
			ItemDao iD = new ItemDao();
			PreparedStatement insertAuction = conn
					.prepareStatement(Queries.insertAuction);
			try {
				insertAuction
						.setInt(1, iD.getItemId(a.getItem().getItemName()));
			} catch (NoItemFoundException e) {
				e.getMessage();
				e.printStackTrace();
			}

			insertAuction.setInt(2, a.getItem().getUserId());
			insertAuction.setDouble(3, a.getReservePrice());
			insertAuction.setInt(4, a.getAuctionLength());
			insertAuction.setInt(5, a.getAuctionType());
			int rs = insertAuction.executeUpdate();
			if (rs == 0)
				throw new InsertAuctionException("Auction Not Inserted :/");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		AbsDao.closeConnection();

	}

	@Override
	public Map<Auction, User> getAuctionByType(int type, int uid)
			throws NoAuctionFoundException {
		Map<Auction, User> hashMapAuction=new HashMap<Auction,User>();
		conn = AbsDao.getConnection();
		try {
			PreparedStatement getAuction=conn.prepareStatement(Queries.getAuctionType);
			getAuction.setInt(1, type);
			getAuction.setInt(2, uid);
			ResultSet rs=getAuction.executeQuery();
			while(rs.next()){
				Auction testAuc=new Auction(); 
				Item testItem=new Item();
				User testUser=new User();
				testItem.setItemId(rs.getInt("itemid"));
				testItem.setItemName(rs.getString("itemname"));
				testItem.setItemDescription(rs.getString("description"));
				testItem.setItemCategory(rs.getString("category"));
				testItem.setUserId(rs.getInt("userid"));
				testAuc.setItem(testItem);
				testAuc.setAucId(rs.getInt("auctionid"));
				testAuc.setReservePrice(rs.getDouble("reserveprice"));
				testAuc.setAuctionLength(rs.getInt("length"));
				testAuc.setAuctionStatus(rs.getInt("status"));
				testUser.setUserName(rs.getString("name"));
				testUser.setUserNationality(rs.getString("nationality"));
				testUser.setUserCompany(rs.getString("company"));
				testUser.setUserContact(rs.getString("contact"));
				/*System.out.println(testAuc);
				System.out.println(testUser);*/
				hashMapAuction.put(testAuc, testUser);
				//System.out.println(hashMapAuction);
			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		AbsDao.closeConnection();
		/*The following  r d satements used to iterate when we messed up :(
		System.out.println(hashMapAuction.size());
		Iterator it = hashMapAuction.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Auction, User> pair = (Entry<Auction, User>) it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
		for (Entry<Auction, User> entry : hashMapAuction.entrySet())
		{
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}*/
		return hashMapAuction;
	}

	public List<Auction> getMyAuction(int uid) throws NoAuctionFoundException {
		List<Auction> myAucList=new ArrayList<Auction>();
		conn=AbsDao.getConnection();
		try {
			PreparedStatement getMyAuctions=conn.prepareStatement(Queries.getMyAuction);
			getMyAuctions.setInt(1, uid);
			ResultSet rs=getMyAuctions.executeQuery();
			while(rs.next()){
				Auction testAuc=new Auction(); 
				Item testItem=new Item();
				testItem.setItemId(rs.getInt("itemid"));
				testItem.setItemName(rs.getString("itemname"));
				testItem.setItemDescription(rs.getString("description"));
				testItem.setItemCategory(rs.getString("category"));
				testItem.setUserId(rs.getInt("userid"));
				testAuc.setItem(testItem);
				testAuc.setAucId(rs.getInt("auctionid"));
				testAuc.setReservePrice(rs.getDouble("reserveprice"));
				testAuc.setAuctionLength(rs.getInt("length"));
				testAuc.setAuctionStatus(rs.getInt("status"));
				/*System.out.println(testAuc);
				System.out.println(testUser);*/
				/*System.out.println(testAuc);*/
				myAucList.add(testAuc);
				//System.out.println(hashMapAuction);
			}
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		AbsDao.closeConnection();
		/*System.out.println(myAucList);*/
		return myAucList;
	}
}
