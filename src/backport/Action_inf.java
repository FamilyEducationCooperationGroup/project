package backport;
import com.opensymphony.xwork2.ActionSupport;
public class Action_inf extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int MESID;
	int refesh;
	String person;
	String DTA;
	String STR;
	String originuser;
	public String inf() {
		if(refesh==1)
		{
		DbTools.Rsfresh_unread(originuser,-1);
		}
		STR=DbTools.Querry_Information(MESID,person,DTA,refesh).STR;
		return "SUCCESS";
	}
	public int getMESID() {
		return MESID;
	}
	public void setMESID(int mESID) {
		MESID = mESID;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getDTA() {
		return DTA;
	}
	public void setDTA(String dTA) {
		DTA = dTA;
	}
	public String getSTR() {
		return STR;
	}
	public void setSTR(String sTR) {
		STR = sTR;
	}
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
	public int getRefesh() {
		return refesh;
	}
	public void setRefesh(int refesh) {
		this.refesh = refesh;
	}
}
