package com.sapient.dao;

public interface Queries {
	String loginValidation = "Select password From login Where name=?";
	String insertUser = "Insert Into login(name,company, contact, nationality,password) Values(?,?,?,?,?)";
	String getUserInfo = "Select * From login Where name=?";

	String insertItem = "Insert Into item(userid,itemname,description,category) values(?,?,?,?)";
	String getItemInfo = "Select * From item Where itemname=?";

	String insertAuction = "Insert Into auction(itemid,userid,reserveprice,length,type) Values(?,?,?,?,?)";
	
	String getAuction = "Select * from auction where type=?";
	
	String insertBid = "Insert Into bids(auctionid,userid,bidprice) Values(?,?,?)";
	
	String getAuctionType = "Select name,status,company,contact,nationality,auctionid,i.itemid as itemid,a.userid as userid,"
			+ "reserveprice,length,itemname,description,category "
			+ "from auction as a inner join item as i on i.itemid=a.itemid "
			+ "inner join login as l on l.id=a.userid and type=? and a.userid!=?";

	
	String getMyAuction = "Select auctionid,i.itemid as itemid,a.userid as userid,status,reserveprice,"
			+ "length,itemname,description,category from auction as a inner join "
			+ "item as i on i.itemid=a.itemid and a.userid=?";
	
	
	String getBidStatus = "select i.itemname as itemname,i.description as description,i.category as category,"
			+ "l.name as maxbidder,l2.name as owner,status,a.userid as ownerid,l.contact as contact,a.itemid,"
			+ "l.nationality as nationality,l.company,b.bidid,b.auctionid,b.userid as bidderid,max(bidprice) as maxbid"
			+ " from bids as b inner join login as l on l.id=b.userid inner join auction as a on b.auctionid=a.auctionid"
			+ " inner join login as l2 on a.userid=l2.id inner join item as i on i.itemid=a.itemid group by auctionid order by auctionid";
}
