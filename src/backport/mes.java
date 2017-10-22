package backport;
public class mes {
	public mes(String frm, String dTA, String sTR, int readed) {
		super();
		this.frm = frm;
		DTA = dTA;
		STR = sTR;
		this.readed = readed;
	}
	String frm;
	String DTA;
	String STR;
	int readed;
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
