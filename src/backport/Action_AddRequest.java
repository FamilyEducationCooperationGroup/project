package backport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class Action_AddRequest {
	private Map<String, Object>session;
	String frm,to;
	String match_mes;
	public String AddRequest() {
		pj p1,p2;
		String DTA;
		Date day=new Date();
		DbTools.Rsfresh_Man("MMMM",1,1);
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		frm=(String)session.get("obj1");
		to=(String)session.get("obj2");
		if(frm==null) {
			return "FAILED";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		DTA=df.format(day);
		p1=new pj(to, "    "+match_mes,DTA,3,-1,"");
		p2=new pj(frm,"    "+match_mes,DTA,1,-1,"");
		if(
		(DbTools.CheckPjByusername(to,frm)==-1)&&
		(DbTools.CheckPjByusername(frm,to)==-1)
		)
		{
			DbTools.Add_pj(p1,frm);
			DbTools.Add_pj(p2,to);
			DbTools.Rsfresh_Man(to,1,0);
			return "SUCCESS";
		}
		return "FAILED";
	}
	public String getFrm() {
		return frm;
	}
	public void setFrm(String frm) {
		this.frm = frm;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMatch_mes() {
		return match_mes;
	}
	public void setMatch_mes(String match_mes) {
		this.match_mes = match_mes;
	}
}
