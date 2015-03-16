package com.sapient.dao;

import com.sapient.exceptions.BidNotInsertedException;
import com.sapient.vo.Bid;

public interface BidImplementation {
	public void insertBid(Bid newbid) throws BidNotInsertedException;
	
}
