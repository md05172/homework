package controller;

import java.util.HashMap;
import java.util.Map;

import handler.DeleteHandler;
import handler.DetailHandler;
import handler.HomeHandler;
import handler.JoinHandler;
import handler.JoinOkHandler;
import handler.ListHandler;
import handler.LoginHandler;
import handler.LoginOkHandler;
import handler.UpdateHandler;
import handler.UpdateOkHandler;
import handler.WriteHandler;
import handler.WriteOkHandler;

public class RequestMapping {
	private static final Map<RequestKeyValue, Controller> mapping = new HashMap<>();
	
	public static void init() {
		mapping.put(new RequestKeyValue("/home.hrd", "GET"), new HomeHandler());
		mapping.put(new RequestKeyValue("/write.hrd", "GET"), new WriteHandler());
		mapping.put(new RequestKeyValue("/write.hrd", "POST"), new WriteOkHandler());
		mapping.put(new RequestKeyValue("/list.hrd", "GET"), new ListHandler());
		mapping.put(new RequestKeyValue("/detail.hrd", "GET"), new DetailHandler());
		mapping.put(new RequestKeyValue("/update.hrd", "GET"), new UpdateHandler());
		mapping.put(new RequestKeyValue("/update.hrd", "POST"), new UpdateOkHandler());
		mapping.put(new RequestKeyValue("/delete.hrd", "POST"), new DeleteHandler());
		mapping.put(new RequestKeyValue("/join.hrd", "GET"), new JoinHandler());
		mapping.put(new RequestKeyValue("/join.hrd", "POST"), new JoinOkHandler());
		mapping.put(new RequestKeyValue("/login.hrd", "GET"), new LoginHandler());
		mapping.put(new RequestKeyValue("/login.hrd", "POST"), new LoginOkHandler());
		mapping.put(new RequestKeyValue("/logout.hrd", "POST"), new LogOutOkHandler());
	}
	
	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
	
}
