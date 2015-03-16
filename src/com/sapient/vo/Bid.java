package com.sapient.vo;

public class Bid {
	private int bidId;
	private int userId;
	private int aucId;
	private double bidPrice;
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAucId() {
		return aucId;
	}
	public void setAucId(int aucId) {
		this.aucId = aucId;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Bid() {
	}
	public Bid(int bidId, int userId, int aucId, double bidPrice) {
		this.bidId = bidId;
		this.userId = userId;
		this.aucId = aucId;
		this.bidPrice = bidPrice;
	}
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", userId=" + userId + ", aucId="
				+ aucId + ", bidPrice=" + bidPrice + "]";
	}
	
}
