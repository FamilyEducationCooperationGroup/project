package backport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Action_Syspj extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	syspj ipt;
	String STR;
	String username;
	private Map<String, Object>session;
	public String Syspj()
	{
		String DTA;
		Date day;
		day=new Date();
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		username=(String)session.get("obj1");
		if(STR.equals(""))
		{
			return "EMPTY";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		DTA=df.format(day);
		ipt=new syspj("    "+STR,DTA,username);
		DbTools.Add_SysPj(ipt);
		return SUCCESS;
	}
	public syspj getIpt() {
		return ipt;
	}
	public void setIpt(syspj ipt) {
		this.ipt = ipt;
	}
	public String getSTR() {
		return STR;
	}
	public void setSTR(String sTR) {
		STR = sTR;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
