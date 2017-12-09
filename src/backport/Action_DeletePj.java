package backport;
import com.opensymphony.xwork2.ActionSupport;
public class Action_DeletePj  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String originuser;
	String frm;
	public String DeletePj() {
		int s=DbTools.CheckPjByusername(originuser,frm);
		if(DbTools.CheckPjByusername(originuser,frm)==4) {
			DbTools.Rsfresh_Man(originuser,-1,0);
		}
		DbTools.Delete_pj(originuser,frm);
		DbTools.Delete_pj(frm,originuser);
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
}
