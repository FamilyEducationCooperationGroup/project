package backport;
public class man_out {
	
	public man_out(String username, String job, String name, String sex, String grade, String subject, String tel,
			String price, String avestar, int oknum, String time, String place) {
		super();
		this.username = username;
		this.job = job;
		this.name = name;
		this.sex = sex;
		this.grade = grade;
		this.subject = subject;
		this.tel = tel;
		this.price = price;
		this.avestar = avestar;
		this.oknum = oknum;
		this.time = time;
		this.place = place;
	}
	String username;
	String job;
	String name;
	String sex;
	String grade;
	String subject;
	String tel;
	String price;
	String avestar;
	int oknum;
	String time;
	String place;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	
	public String getAvestar() {
		return avestar;
	}
	public void setAvestar(String avestar) {
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
