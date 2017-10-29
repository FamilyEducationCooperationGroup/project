package backport;
import com.opensymphony.xwork2.ActionSupport;
public class Action_DelJd extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String frm,to;
	public String DelJd() {
		DbTools.Delete_Assess(frm,to);
		return "SUCCESS";
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

}
