package backport;
import com.opensymphony.xwork2.ActionSupport;
public class Action_Confirm extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String originuser;
	String DTA;
	String frm;
	public String Confirm() {
		DbTools.SetPjInt(originuser, frm, DTA,4,5);
		DbTools.Rsfresh_Man(originuser,-1,0);
		return "SUCCESS";
	}
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
	public String getDTA() {
		return DTA;
	}
	public void setDTA(String dTA) {
		DTA = dTA;
	}
	public String getFrm() {
		return frm;
	}
	public void setFrm(String frm) {
		this.frm = frm;
	}
}
