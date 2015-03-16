package com.sapient.vo;

public class BidStatus {
	private String maxBidder;
	private User itemOwner;
	private Item itemDetails;
	private Bid bidDetails;
	private int bidStatus;
	public int getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(int bidStatus) {
		this.bidStatus = bidStatus;
	}
	public String getMaxBidder() {
		return maxBidder;
	}
	public void setMaxBidder(String maxbidder) {
		this.maxBidder = maxbidder;
	}
	public User getItemOwner() {
		return itemOwner;
	}
	public void setItemOwner(User itemOwner) {
		this.itemOwner = itemOwner;
	}
	public Item getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(Item itemDetails) {
		this.itemDetails = itemDetails;
	}
	public Bid getBidDetails() {
		return bidDetails;
	}
	public void setBidDetails(Bid bidDetails) {
		this.bidDetails = bidDetails;
	}
	public BidStatus() {
	}
	
	public BidStatus(String maxbidder, User itemOwner, Item itemDetails,
			Bid bidDetails, int bidStatus) {
		this.maxBidder = maxbidder;
		this.itemOwner = itemOwner;
		this.itemDetails = itemDetails;
		this.bidDetails = bidDetails;
		this.bidStatus = bidStatus;
	}
	@Override
	public String toString() {
		return "BidStatus [maxbidder=" + maxBidder + ", itemOwner=" + itemOwner
				+ ", itemDetails=" + itemDetails + ", bidDetails=" + bidDetails
				+ ", bidStatus=" + bidStatus + "]";
	}
	
	
}
