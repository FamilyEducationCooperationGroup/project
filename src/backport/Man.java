package backport;
public class Man {
	
	public Man(String username, int job, String name, int sex, String pwd, String grade, String subject, String tel,
			int mESID, int pJID, int unread, int price, int avestar, int oknum, String time, int place, int starnum) {
		super();
		this.username = username;
		this.job = job;
		this.name = name;
		this.sex = sex;
		this.pwd = pwd;
		this.grade = grade;
		this.subject = subject;
		this.tel = tel;
		MESID = mESID;
		PJID = pJID;
		this.unread = unread;
		this.price = price;
		this.avestar = avestar;
		this.oknum = oknum;
		this.time = time;
		this.place = place;
		this.starnum = starnum;
	}
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
	int unread;
	int price;
	int avestar;
	int oknum;
	String time;
	int place;
	int starnum;
	public int getUnread() {
		return unread;
	}
	public void setUnread(int unread) {
		this.unread = unread;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAve_star() {
		return avestar;
	}
	public void setAve_star(int avestar) {
		this.avestar = avestar;
	}
	public int getOk_num() {
		return oknum;
	}
	public void setOk_num(int oknum) {
		this.oknum = oknum;
	}
	public int getAvestar() {
		return avestar;
	}
	public void setAvestar(int avestar) {
		this.avestar = avestar;
	}
	public int getOknum() {
		return oknum;
	}
	public void setOknum(int oknum) {
		this.oknum = oknum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public int getStarnum() {
		return starnum;
	}
	public void setStarnum(int starnum) {
		this.starnum = starnum;
	}
	
}
