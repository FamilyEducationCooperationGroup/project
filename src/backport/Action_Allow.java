package backport;
import com.opensymphony.xwork2.ActionSupport;
public class Action_Allow extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String originuser;
	String frm;
	String DTA;
	public String Allow() {
		DbTools.SetPjInt(frm,originuser, DTA,4,4);
		DbTools.SetPjInt(originuser, frm, DTA, 4,2);
		DbTools.Rsfresh_unread(originuser,-1);
		DbTools.Rsfresh_unread(frm,1);
		return "SUCCESS";
	}
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
	public String getFrm() {
		return frm;
	}
	public void setFrm(String frm) {
		this.frm = frm;
	}
	public String getDTA() {
		return DTA;
	}
	public void setDTA(String dTA) {
		DTA = dTA;
	}
}
