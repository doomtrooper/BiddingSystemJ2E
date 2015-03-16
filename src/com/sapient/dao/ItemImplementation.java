package com.sapient.dao;

import com.sapient.exceptions.InsertItemException;
import com.sapient.exceptions.NoItemFoundException;
import com.sapient.vo.Item;

public interface ItemImplementation {
	public void insertItem(Item i) throws InsertItemException;
	public int getItemId(String itemName) throws NoItemFoundException;
}
