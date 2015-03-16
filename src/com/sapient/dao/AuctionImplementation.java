package com.sapient.dao;

import java.util.List;
import java.util.Map;

import com.sapient.exceptions.InsertAuctionException;
import com.sapient.exceptions.NoAuctionFoundException;
import com.sapient.vo.Auction;
import com.sapient.vo.User;

public interface AuctionImplementation {
	public void insertAuction(Auction a) throws InsertAuctionException;
	public Map<Auction,User> getAuctionByType(int type,int uid) throws NoAuctionFoundException;
	public List<Auction> getMyAuction(int uid ) throws NoAuctionFoundException;
}
