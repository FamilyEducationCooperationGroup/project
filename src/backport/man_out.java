package backport;
public class man_out {
	public man_out(String username, String job, String name, String sex, String grade, String subject, String tel) {
		super();
		this.username = username;
		this.job = job;
		this.name = name;
		this.sex = sex;
		this.grade = grade;
		this.subject = subject;
		this.tel = tel;
	}
	String username;
	String job;
	String name;
	String sex;
	String grade;
	String subject;
	String tel;
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
}
