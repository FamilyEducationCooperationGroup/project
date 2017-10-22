package backport;
import com.opensymphony.xwork2.ActionSupport;
public class Login extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Man person;
	String username;
	int job;
	String name;
	int sex;
	String pwd;
	int[] grades;
	int[] subjects;
	String tel;
	int MESID;
	int PJID;
	//person=new Man(username,job,name,sex,pwd,Fill_Grades(grades),Fill_Subjects(subjects),tel,MESID,PJID);
	private String Fill_Subjects(int[] p) {
		char []ans;
		ans=new char[9];
		for (int i=0;i<9;i++)
			ans[i]=0;
		for(int i=0;i<p.length;i++)
		{
			ans[p[i]]=1;
		}
		return ans.toString();
	}
	private String Fill_Grades(int[] p) {
		char []ans;
		ans=new char[12];
		for (int i=0;i<12;i++)
			ans[i]=0;
		for(int i=0;i<p.length;i++)
		{
			ans[p[i]]=1;
		}
		return ans.toString();
	}
	public String login() {
		person=new Man(username,job,name,sex,pwd,Fill_Grades(grades),Fill_Subjects(subjects),tel,MESID,PJID);
		person=DbTools.Fill(person);
		if(person==null)
		{			
			return "FAILED";
		}
		return "SUCCESS";
	}
	public Man getPerson() {
		return person;
	}
	public void setPerson(Man person) {
		this.person = person;
	}
	public int[] getSubjects() {
		return subjects;
	}
	public void setSubjects(int[] subjects) {
		this.subjects = subjects;
	}
	public int[] getGrades() {
		return grades;
	}
	public void setGrades(int[] grades) {
		this.grades = grades;
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
