package backport;
import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Action_Signin extends ActionSupport {
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
	int unread;
	private String Fill_Subjects(int[] p) {
		char []ans;
		ans=new char[]{'0','0','0','0','0','0','0','0','0'};
		for(int i=0;i<p.length;i++)
		{
			ans[p[i]-1]='1';
		}
		return String.valueOf(ans);
	}
	private String Fill_Grades(int[] p) {
		char []ans;
		ans=new char[]{'0','0','0','0','0','0','0','0','0','0','0','0'};
		for(int i=0;i<p.length;i++)
		{
			ans[p[i]-1]='1';
		}
		return String.valueOf(ans);
	}
	public String signin() {
		person=new Man(username,job,name,sex,pwd,Fill_Grades(grades),Fill_Subjects(subjects),tel,MESID,PJID,unread);
		Man temp;
		temp=new Man(person.username,2,null,2,null,null,null,null,0,0,0);
		Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(tel);
		if(username==null){
			return "FAILED1";//未输入用户名
		}
		else if (pwd==null)
		{
			return "FAILED2";//未输入密码
		}
		else if ((person.subject).equals("000000000"))
		{
			return "FAILED3";//未选择科目
		}
		else if ((person.grade).equals("000000000000"))
		{
			return "FAILED4";//未选择年级
		}
		else if (!isNum.matches()||tel.length()>11)
		{
			return "FAILED5";//电话号格式出错
		}
		else if(DbTools.Querry(temp)!=null){
			temp=new Man(person.username,person.job,person.name,person.sex,person.pwd,person.grade,person.subject,person.tel,0,0,0);
			DbTools.Add(temp);
			return "SUCCESS";
		}
	    	return "FAILED2";
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
