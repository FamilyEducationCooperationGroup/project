package backport;
import com.opensymphony.xwork2.ActionSupport;
public class Action_del extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int MESID;
	String DTA;
	String person;
	public String del()
	{
		DbTools.Delete_Message(MESID,person,DTA);
		return "SUCCESS";
	}
	public int getMESID() {
		return MESID;
	}
	public void setMESID(int mESID) {
		MESID = mESID;
	}
	public String getDTA() {
		return DTA;
	}
	public void setDTA(String dTA) {
		DTA = dTA;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
}
