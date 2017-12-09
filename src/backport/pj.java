package backport;
//´æ´¢ÁªÏµÈË
public class pj {
	public pj(String frm, String mes, String dTA, int proc, int star, String judgement) {
		super();
		this.frm = frm;
		this.mes = mes;
		DTA = dTA;
		this.proc = proc;
		this.star = star;
		this.judgement = judgement;
	}
	String frm;
	String mes;
	String DTA;
	int proc;
	int star;
	String judgement;
	public String getFrm() {
		return frm;
	}
	public void setFrm(String frm) {
		this.frm = frm;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getDTA() {
		return DTA;
	}
	public void setDTA(String dTA) {
		DTA = dTA;
	}
	public int getProc() {
		return proc;
	}
	public void setProc(int proc) {
		this.proc = proc;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getJudgement() {
		return judgement;
	}
	public void setJudgement(String judgement) {
		this.judgement = judgement;
	}
}
