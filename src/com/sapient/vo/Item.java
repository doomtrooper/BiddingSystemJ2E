package com.sapient.vo;

public class Item {
	private int itemId;
	private int userId;
	private String itemName;
	private String itemCategory;
	private String itemDescription;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Item() {
	}
	public Item(int itemId, int userId, String itemName, String itemCategory,
			String itemDescription) {
		this.itemId = itemId;
		this.userId = userId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", userId=" + userId + ", itemName="
				+ itemName + ", itemCategory=" + itemCategory
				+ ", itemDescription=" + itemDescription + "]";
	}
	
}
