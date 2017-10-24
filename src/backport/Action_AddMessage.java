package backport;
import java.util.Date;
import java.util.Map;

import org.apache.catalina.Context;

import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Action_AddMessage extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int pos;
	String sender;
	String addressee;
	String date;
	String message;
	int readed;
	Date day;
	private Map<String, Object>session;
	public String add_Message() {
		day=new Date();
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		sender=(String)session.get("obj1");
		addressee=(String)session.get("obj2");
		//session.remove("obj1");
		//session.remove("obj2");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		date=df.format(day);
		System.out.println(date);
		DbTools.Add_Message(sender, addressee, date, message);
		return "SUCCESS";
	}
	
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getReaded() {
		return readed;
	}
	public void setReaded(int readed) {
		this.readed = readed;
	}
}
