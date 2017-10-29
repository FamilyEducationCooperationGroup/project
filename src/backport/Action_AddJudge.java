package backport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Action_AddJudge extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int star;
	String STR;
	private Map<String, Object>session;
	public String AddJudge() {
		Date day=new Date();
		String DTA;
		String frm;
		String to;
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		frm=(String)session.get("obj1");
		to=(String)session.get("obj2");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		DTA=df.format(day);
			Ass j2=new Ass(to, DTA,STR, star,1);
			DbTools.Add_Update_Assess(frm,j2);
			return "SUCCESS";
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getSTR() {
		return STR;
	}
	public void setSTR(String sTR) {
		STR = sTR;
	}
}
