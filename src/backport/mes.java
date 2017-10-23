package backport;
public class mes {
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getPerson() {
		return person;
	}
	public mes(int pos, String person, String dTA, String sTR, int readed) {
		super();
		this.pos = pos;
		this.person = person;
		DTA = dTA;
		STR = sTR;
		this.readed = readed;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	int pos;
	String person;
	String DTA;
	String STR;
	int readed;
	
	
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
	public int getReaded() {
		return readed;
	}
	public void setReaded(int readed) {
		this.readed = readed;
	}
}
