package com.lov.service;

import com.heygis.beans.User;
import com.heygis.dao.UserDAOImpl;

public class FillInfoService {
	UserDAOImpl udi = new UserDAOImpl();
	public boolean fillInfo(User user){
		return udi.fillInfo(user);
	}
}
