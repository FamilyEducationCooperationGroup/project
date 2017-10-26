package backport;
public class mes {
	public mes(int pos, String person, String dTA, String sTR, int readed, String brief) {
		super();
		this.pos = pos;
		this.person = person;
		DTA = dTA;
		STR = sTR;
		this.readed = readed;
		this.brief = brief;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	int pos;
	String person;
	String DTA;
	String STR;
	int readed;
	String brief;
	
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
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
}
