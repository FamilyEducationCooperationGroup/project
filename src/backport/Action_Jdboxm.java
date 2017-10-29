package backport;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
public class Action_Jdboxm extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String originuser;
	ArrayList<Ass> jdList;
	public String Jdbox() {
		jdList=DbTools.Querry_Assess(originuser,null,1);
		return "SUCCESS";
	}
	
	
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
	public ArrayList<Ass> getJdList() {
		return jdList;
	}
	public void setJdList(ArrayList<Ass> jdList) {
		this.jdList = jdList;
	}
}
