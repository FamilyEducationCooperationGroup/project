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
	ArrayList<pj>  request_wait;
	ArrayList<pj>  ans_wait;
	ArrayList<pj>  ans_requested;
	public String Show_Mails() {
		newget=DbTools.QuerryMes(1,0,MESID);
		geted=DbTools.QuerryMes(1,1,MESID);
		post=DbTools.QuerryMes(0,1,MESID);
		request_wait=DbTools.QuerryPj(3,MESID);//等待对方接受
		ans_wait=DbTools.QuerryPj(1,MESID);//对方等待你接受
		ans_requested=DbTools.QuerryPj(4,MESID);//对方已接受
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
	public ArrayList<pj> getRequest_wait() {
		return request_wait;
	}
	public void setRequest_wait(ArrayList<pj> request_wait) {
		this.request_wait = request_wait;
	}
	public ArrayList<pj> getAns_wait() {
		return ans_wait;
	}
	public void setAns_wait(ArrayList<pj> ans_wait) {
		this.ans_wait = ans_wait;
	}
	public ArrayList<pj> getAns_requested() {
		return ans_requested;
	}
	public void setAns_requested(ArrayList<pj> ans_requested) {
		this.ans_requested = ans_requested;
	}
}
