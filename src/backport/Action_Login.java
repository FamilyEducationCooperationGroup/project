package backport;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
public class Action_Login extends ActionSupport {
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
	ArrayList<man_out> result = new ArrayList<man_out>();
	ArrayList<man_out> convertResult(ArrayList<Man> ipt){
		ArrayList<man_out> ans=new ArrayList<man_out>();
		for(Man m:ipt) {
			String un;
			String jb;
			String ne;
			String sx;
			String gd;
			String ss;
			String tl;
			un=m.username;
			if(m.job==0) {
				jb="学生";
			}
			else{
				jb="老师";
			}
			ne=m.name;
			if(m.sex==0) {
				sx="男";
			}
			else{
				sx="女";
			}
			tl=m.tel;
			gd=convertGrades(m.grade);
			ss=convertSubjects(m.subject);
			man_out mo=new man_out(un,jb,ne,sx,gd,ss,tl);
			ans.add(mo);
		}
		return ans;	
	}
	private String convertSubjects(String subject) {
		String ans="";
		String[] dic= {"数学","语文","英语","物理","化学","生物","历史","地理","政治"};
		for(int i=0;i<9;i++) {
			
		}
		return null;
	}
	private String convertGrades(String grade) {
		// TODO Auto-generated method stub
		return null;
	}
	public String login() {
		person=new Man(username,2,null,2,pwd,null,null,null,0,0);
		person=DbTools.Fill(person);
		if(person==null)
		{			
			return "FAILED";
		}
		result=convertResult(DbTools.Match(person));
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
	public ArrayList<man_out> getResult() {
		return result;
	}
	public void setResult(ArrayList<man_out> result) {
		this.result = result;
	}
}
