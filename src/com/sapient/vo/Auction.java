package com.sapient.vo;

public class Auction{
	private Item item;
	private double reservePrice;
	private int auctionLength;
	private int auctionStatus;
	private int auctionType;
	private int aucId;
	public int getAucId() {
		return aucId;
	}
	public void setAucId(int aucId) {
		this.aucId = aucId;
	}
	public int getAuctionType() {
		return auctionType;
	}
	public void setAuctionType(int auctionType) {
		this.auctionType = auctionType;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public double getReservePrice() {
		return reservePrice;
	}
	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}
	public int getAuctionLength() {
		return auctionLength;
	}
	public void setAuctionLength(int auctionLength) {
		this.auctionLength = auctionLength;
	}
	public int getAuctionStatus() {
		return auctionStatus;
	}
	public void setAuctionStatus(int auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
	public Auction() {
	}
	
	@Override
	public String toString() {
		return "Auction [item=" + item + ", reservePrice=" + reservePrice
				+ ", auctionLength=" + auctionLength + ", auctionStatus="
				+ auctionStatus + ", auctionType=" + auctionType + ", aucId="
				+ aucId + "]";
	}
	public Auction(Item item, double reservePrice, int auctionLength,
			int auctionStatus, int auctionType, int aucId) {
		this.item = item;
		this.reservePrice = reservePrice;
		this.auctionLength = auctionLength;
		this.auctionStatus = auctionStatus;
		this.auctionType = auctionType;
		this.aucId = aucId;
	}
	
	
}
