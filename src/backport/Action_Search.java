package backport;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class Action_Search extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Man person;
	String username;
	String originuser;
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
	private Map<String, Object>session;
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
		String[] dic= {"数","语","外","理","化","生","史","地","政"};
		char[] temp=subject.toCharArray();
		for(int i=0;i<9;i++) {
			if(temp[i]=='1') {
				ans+=dic[i];
			}
		}
		return ans;
	}
	private String convertGrades(String grade) {
		String ans="";
		String[] dic= {"小一","小二","小三","小四","小五","小六","初一","初二","初三","高一","高二","高三"};
		char[] temp=grade.toCharArray();
		for(int i=0;i<12;i++) {
			if(temp[i]=='1') {
				ans+=dic[i];
			}
		}
		return ans;
	}
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
	public String search() {
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		originuser=(String)session.get("obj1");
		if (username.equals(""))
			username=null;
		if (name.equals(""))
			name=null;
		person=new Man(username,job,name,sex,null,Fill_Grades(grades),Fill_Subjects(subjects),null,0,0,0);
		result=convertResult(DbTools.Querry(person));
		if(result==null)		
			return "FAILED";
		else
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
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public ArrayList<man_out> getResult() {
		return result;
	}
	public void setResult(ArrayList<man_out> result) {
		this.result = result;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public int getUnread() {
		return unread;
	}
	public void setUnread(int unread) {
		this.unread = unread;
	}
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
}
