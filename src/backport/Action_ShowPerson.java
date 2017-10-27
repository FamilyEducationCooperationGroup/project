package backport;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
public class Action_ShowPerson  extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String originuser;
	int MESID;
	ArrayList<pj> personlist;
	public String ShowPerson() {
		personlist=DbTools.QuerryPj(2,MESID);
		ArrayList<pj> personlist2=DbTools.QuerryPj(4,MESID);
		for(pj p : personlist2){
			personlist.add(p);
		}
		personlist2=DbTools.QuerryPj(5,MESID);
		for(pj p : personlist2){
			personlist.add(p);
		}
		return "SUCCESS";
	}
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
	public int getMESID() {
		return MESID;
	}
	public void setMESID(int mESID) {
		MESID = mESID;
	}
	public ArrayList<pj> getPersonlist() {
		return personlist;
	}
	public void setPersonlist(ArrayList<pj> personlist) {
		this.personlist = personlist;
	}
}
