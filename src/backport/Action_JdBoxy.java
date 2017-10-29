package backport;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
public class Action_JdBoxy extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String to;
	ArrayList<Ass> JdBoxyList;
    public String JdBoxy() {
    	JdBoxyList=DbTools.Querry_Assess(to,null, 0);
    	return "SUCCESS";
}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public ArrayList<Ass> getJdBoxyList() {
		return JdBoxyList;
	}
	public void setJdBoxyList(ArrayList<Ass> jdBoxyList) {
		JdBoxyList = jdBoxyList;
	}
}
