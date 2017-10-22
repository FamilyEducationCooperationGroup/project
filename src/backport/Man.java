package backport;
public class Man {
	String username;
	int job;
	String name;
	int sex;
	String pwd;
	String grade;
	String subject;
	String tel;
	int MESID;
	int PJID;
	public Man(String username, int job, String name, int sex, String pwd, String grade, String subject, String tel,
			int MESID, int PJID) {
		super();
		this.username = username;
		this.job = job;
		this.name = name;
		this.sex = sex;
		this.pwd = pwd;
		this.grade = grade;
		this.subject = subject;
		this.tel = tel;
		this.MESID=MESID;
		this.PJID=PJID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getJob() {
		return job;
	}
	public void setJob(int job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getMESID() {
		return MESID;
	}
	public void setMESID(int mESID) {
		MESID = mESID;
	}
	public int getPJID() {
		return PJID;
	}
	public void setPJID(int pJID) {
		PJID = pJID;
	}
	
}
