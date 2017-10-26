package backport;

public class syspj {
	public syspj(String sTR, String dTA, String username) {
		super();
		STR = sTR;
		DTA = dTA;
		this.username = username;
	}
	String STR;
	String DTA;
	String username;
	
	public String getSTR() {
		return STR;
	}
	public void setSTR(String sTR) {
		STR = sTR;
	}
	public String getDTA() {
		return DTA;
	}
	public void setDTA(String dTA) {
		DTA = dTA;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
