package com.sapient.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.sapient.dao.AuctionDao;
import com.sapient.dao.BidDao;
import com.sapient.dao.ItemDao;
import com.sapient.dao.UserDao;
import com.sapient.exceptions.BidNotInsertedException;
import com.sapient.exceptions.InsertAuctionException;
import com.sapient.exceptions.InsertItemException;
import com.sapient.exceptions.InsertUserException;
import com.sapient.exceptions.NoAuctionFoundException;
import com.sapient.exceptions.NoBidFoundException;
import com.sapient.exceptions.UserAlreadyExistsException;
import com.sapient.exceptions.UserNotFoundException;
import com.sapient.vo.Auction;
import com.sapient.vo.Bid;
import com.sapient.vo.BidStatus;
import com.sapient.vo.Item;
import com.sapient.vo.User;

/**
 * Servlet implementation class BidManager
 */
public class BidManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BidManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = null;
		User cur_user = new User();
		UserDao check_user = new UserDao();
		AuctionDao aucDao = new AuctionDao();
		BidDao bidDao=new BidDao();
		String url = request.getServletPath();
		if (url.equals("/login")) {
			String uname = request.getParameter("username");
			String upass = request.getParameter("password");
			check_user = new UserDao();
			try {
				if (upass.equals(check_user.getPassword(uname))) {
					// System.out.println(check_user.getPassword(uname));
					session = request.getSession(true);
					session.setAttribute("loggedInUser", true);
					cur_user = check_user.getUser(uname);
					// System.out.println(cur_user);
					int userid = cur_user.getUserId();
					session.setAttribute("uid", userid);
					String username = cur_user.getUserName();
					session.setAttribute("uname", username);
					request.setAttribute("welcomemsg",
							"You have successfully Logged in.");
				} else {
					request.setAttribute("errmsg",
							"Error in logging. Please try again.");
				}
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} catch (UserNotFoundException e) {
				e.getMessage();
				e.printStackTrace();
			}
		} else if (url.equals("/logout")) {
			session = request.getSession(false);
			session.invalidate();
			request.setAttribute("logoutmsg",
					"You have been succefully logged out.");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else if (url.equals("/signup")) {
			String uname = request.getParameter("username");
			cur_user.setUserName(request.getParameter("username"));
			cur_user.setUserCompany(request.getParameter("usercompany"));
			cur_user.setUserContact(request.getParameter("usercontact"));
			cur_user.setUserNationality(request.getParameter("usercompany"));
			cur_user.setUserPassword(request.getParameter("userpassword"));

			try {
				check_user.checkExistingUser(uname);
				try {
					check_user.insertUser(cur_user);
					request.setAttribute("registermsg",
							"You have been successfully registered. Login to Continue.");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
				} catch (InsertUserException e) {
					e.getMessage();
					e.printStackTrace();
				}
			} catch (UserAlreadyExistsException e1) {
				e1.getMessage();
				e1.printStackTrace();
			}
		} else if (url.equals("/addauction")) {
			Item newItem = new Item();
			session = request.getSession();
			if (!session.isNew()) {
				// Session is freshly created during this request.
				newItem.setUserId((Integer) session.getAttribute("uid"));
				newItem.setItemName(request.getParameter("iname"));
				newItem.setItemCategory(request.getParameter("icat"));
				newItem.setItemDescription(request.getParameter("idesc"));
			}
			ItemDao iD = new ItemDao();
			try {
				iD.insertItem(newItem);
			} catch (InsertItemException e) {
				e.getMessage();
				e.printStackTrace();
			}
			Auction newAuction = new Auction();
			System.out.println(request.getParameter("ares")
					+ request.getParameter("atype")
					+ request.getParameter("alen"));
			Double res = Double.parseDouble(request.getParameter("ares"));
			Integer type = Integer.parseInt(request.getParameter("atype"));
			Integer len = Integer.parseInt(request.getParameter("alen"));
			newAuction.setItem(newItem);
			newAuction.setReservePrice(res);
			newAuction.setAuctionType(type);
			newAuction.setAuctionLength(len);
			AuctionDao aD = new AuctionDao();
			// System.out.println(newAuction);
			try {
				aD.insertAuction(newAuction);
			} catch (InsertAuctionException e) {
				e.getMessage();
				e.printStackTrace();
				request.setAttribute("addAucMsg",
						"Auction not created. Solly :(");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			}
			request.setAttribute("addAucMsg", "Auction Created. Haappy now? :P");
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		} else if (url.equals("/viewauction")) {
			int aucType = Integer.parseInt(request.getParameter("type"));
			AuctionDao aD = new AuctionDao();
			session = request.getSession();
			/* List<Auction> auctionList=null; */
			Map<Auction, User> map = null;
			Integer uid = null;
			if (!session.isNew()) {
				// Session is freshly created during this request.
				uid = (Integer) session.getAttribute("uid");
			}
			try {
				map = aD.getAuctionByType(aucType, uid);
				request.setAttribute("map", map);
				// System.out.println(map);
			} catch (NoAuctionFoundException e) {
				e.getMessage();
				e.printStackTrace();
			}
			/*
			 * for (Entry<Auction, User> entry : map.entrySet()) {
			 * System.out.println(entry.getKey() + "/" + entry.getValue()); }
			 */
			request.setAttribute("aucType", aucType);
			if (map.size() == 0)
				request.setAttribute("aucMsg", "Sorry no auction Present :(");
			request.getRequestDispatcher("WEB-INF/ViewAuctions.jsp").forward(
					request, response);
		} else if (url.equals("/setbid")) {
			double bidPrice = Double.parseDouble(request
					.getParameter("bidprice"));
			session = request.getSession(false);
			if (!session.isNew()) {
				Bid newBid = new Bid();
				newBid.setBidPrice(bidPrice);
				// System.out.println(session.getAttribute("uid"));
				newBid.setUserId((Integer) session.getAttribute("uid"));
				newBid.setAucId(Integer.parseInt(request.getParameter("aucid")));
				// System.out.println(request.getParameter("aucid"));
				BidDao newBidDao = new BidDao();
				try {
					newBidDao.insertBid(newBid);
					request.setAttribute("bidMsg",
							"Bid Set. Stay Beautiful ^_^");
					request.getRequestDispatcher("/index.jsp").forward(request,
							response);
				} catch (BidNotInsertedException e) {
					e.getMessage();
					e.printStackTrace();
				}
			} else {
				request.setAttribute("bidMsg", "Bid Not Set. solly :(");
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			}
		} else if (url.equals("/viewmyauction")) {
			List<Auction> myAuc = null;
			session = request.getSession(false);
			if (!session.isNew()) {
				int userid = (Integer) session.getAttribute("uid");
				try {
					myAuc = aucDao.getMyAuction(userid);
					System.out.println(myAuc);
				} catch (NoAuctionFoundException e) {
					e.getMessage();
					e.printStackTrace();
				}
				if (myAuc.size() == 0)
					request.setAttribute("myAucMsg",
							"Out of Luck or money or items :P");
				request.setAttribute("myAucLst", myAuc);
				request.getRequestDispatcher("/WEB-INF/ViewMyAuctions.jsp")
						.forward(request, response);
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			}

		}else if (url.equals("/viewstatus")) {
			List<BidStatus> allBidLst=new ArrayList<BidStatus>();
			try {
				allBidLst=bidDao.getBidStatus();
			} catch (NoBidFoundException e) {
				e.getMessage();
				e.printStackTrace();
			}
			if (allBidLst.size() == 0){
				request.setAttribute("myBidMsg","Out of Luck or money or Bids :P"); }
			request.setAttribute("myBidLst", allBidLst);
			request.getRequestDispatcher("/WEB-INF/ViewAllBids.jsp").forward(request, response);
		}

	}
}
