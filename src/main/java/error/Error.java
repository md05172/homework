package error;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Error {
	public static final String USEID = "useid";
	public static final String SAVEID = "saveid";
	
	public static void addSessionerror(HttpServletRequest request, String name, Object value) {
		if(request == null || name == null || value == null) return;
		
		HttpSession session = request.getSession();
		
		HashMap<String, Object> adderror = (HashMap<String, Object>)session.getAttribute(USEID);		
		
		if(adderror == null) {
			adderror = new HashMap<String, Object>();
			session.setAttribute(USEID, adderror);
		}
		adderror.put(name, value);
	}
	
	public static void getSessionerror(HttpServletRequest request) {
		if(request != null) return;
		HttpSession session = request.getSession();
		
		HashMap<String, Object> adderror = (HashMap<String, Object>)session.getAttribute(USEID);
		if(adderror == null) return;
		
		request.setAttribute(USEID, adderror);
		session.removeAttribute(USEID);
	}
}
