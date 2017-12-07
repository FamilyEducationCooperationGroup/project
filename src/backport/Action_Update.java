package backport;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Action_Update extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Man person;
	String pwd;
	String username;
	int[] grades;
	int[] subjects;
	int[] time;
	String tel;
	int price;
	int place;
	private Map<String, Object>session;
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
	private String Fill_Time(int[] p) {
		char []ans;
		ans=new char[]{'0','0','0','0','0','0','0'};
		for(int i=0;i<p.length;i++)
		{
			ans[p[i]]='1';
		}
		return String.valueOf(ans);
	}
	public String update() {
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		username=(String)session.get("obj1");
		person=new Man(username,2,null,2,pwd,Fill_Grades(grades),Fill_Subjects(subjects),tel,0,0,0,price,0,-1,Fill_Time(time),place,0);
/*
		if((person.subject).equals("000000000")||(person.grade).equals("000000000000")){
			return "FAILED";
		}
*/
		DbTools.Update_Information(person);
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int[] getTime() {
		return time;
	}
	public void setTime(int[] time) {
		this.time = time;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
}
