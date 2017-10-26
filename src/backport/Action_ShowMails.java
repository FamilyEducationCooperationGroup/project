package backport;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

public class Action_ShowMails extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int MESID;
	String originuser;
	ArrayList<mes> newget;
	ArrayList<mes> geted;
	ArrayList<mes> post;
	public String Show_Mails() {
		newget=DbTools.QuerryMes(1,0,MESID);
		geted=DbTools.QuerryMes(1,1,MESID);
		post=DbTools.QuerryMes(0,1,MESID);
		return "SUCCESS";
	}
	public int getMESID() {
		return MESID;
	}
	public void setMESID(int mESID) {
		MESID = mESID;
	}
	public ArrayList<mes> getNewget() {
		return newget;
	}
	public void setNewget(ArrayList<mes> newget) {
		this.newget = newget;
	}
	public ArrayList<mes> getGeted() {
		return geted;
	}
	public void setGeted(ArrayList<mes> geted) {
		this.geted = geted;
	}
	public ArrayList<mes> getPost() {
		return post;
	}
	public void setPost(ArrayList<mes> post) {
		this.post = post;
	}
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
}
