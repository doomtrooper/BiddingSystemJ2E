package com.sapient.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.exceptions.BidNotInsertedException;
import com.sapient.exceptions.NoBidFoundException;
import com.sapient.vo.Bid;
import com.sapient.vo.BidStatus;
import com.sapient.vo.Item;
import com.sapient.vo.User;

public class BidDao implements BidImplementation {
	Connection conn;
	public void insertBid(Bid newbid) throws BidNotInsertedException {
		conn=AbsDao.getConnection();
		try {
			PreparedStatement insertBid=conn.prepareStatement(Queries.insertBid);
			insertBid.setInt(1, newbid.getAucId());
			insertBid.setInt(2, newbid.getUserId());
			insertBid.setDouble(3, newbid.getBidPrice());
			int rs=insertBid.executeUpdate();
			if(rs==0) throw new BidNotInsertedException("Sorry frnd Ur bid was not set :/");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}		
		AbsDao.closeConnection();
	}
	
	public List<BidStatus> getBidStatus() throws NoBidFoundException {
		conn=AbsDao.getConnection();
		List<BidStatus> allBids=new ArrayList<BidStatus>();
		try {
			PreparedStatement getBids=conn.prepareStatement(Queries.getBidStatus);
			ResultSet rs=getBids.executeQuery();
			while(rs.next()){
				User itemOwner=new User();
				Bid bidDetails=new Bid();
				Item itemDetails=new Item();
				BidStatus testBidStatus=new BidStatus();
				itemOwner.setUserName(rs.getString("owner"));
				itemOwner.setUserId(rs.getInt("ownerid"));
				itemOwner.setUserCompany(rs.getString("company"));
				itemOwner.setUserNationality(rs.getString("nationality"));
				itemOwner.setUserPassword(null);
				itemOwner.setUserContact(rs.getString("contact"));
				bidDetails.setBidId(rs.getInt("bidid"));
				bidDetails.setBidPrice(rs.getDouble("maxbid"));
				bidDetails.setAucId(rs.getInt("auctionid"));
				bidDetails.setUserId(rs.getInt("bidderid"));
				itemDetails.setItemName(rs.getString("itemname"));
				itemDetails.setItemDescription(rs.getString("description"));
				itemDetails.setItemCategory(rs.getString("category"));
				testBidStatus.setMaxBidder(rs.getString("maxbidder"));
				testBidStatus.setBidStatus(rs.getInt("status"));
				testBidStatus.setItemOwner(itemOwner);
				testBidStatus.setBidDetails(bidDetails);
				testBidStatus.setItemDetails(itemDetails);
				allBids.add(testBidStatus);
			}
			if(allBids.size()==0) throw new NoBidFoundException("Nothing good is there in this world.:(");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		AbsDao.closeConnection();
		System.out.println(allBids);
		return allBids;
	}

}
