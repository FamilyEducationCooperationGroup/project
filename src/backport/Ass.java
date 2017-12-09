package backport;
public class Ass {//ÆÀ¼Û
	int pos;
	String frm;
	String DTA ;
	String STR ;
	int star;
	public Ass(String frm,String DTA,String STR ,int star,int pos) {
		super();
		this.pos = pos;
		this.frm = frm;
		this.DTA = DTA;
		this.STR = STR;
		this.star = star;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
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
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getFrm() {
		return frm;
	}
	public void setPerson(String frm) {
		this.frm = frm;
	}
	
	
}
