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
	int[] time;
	String tel;
	int MESID;
	int PJID;
	int unread;
	int price;
	int avestar;
	int oknum;
	int place;
	public int jb;
	public int jbself;
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
			String pr;
			String av;
			int ok;
			String tm;
			String pl;
			if(m.starnum!=0)
			{
			av=String.format("%.1f",m.avestar*1.0/9);
			}
			else
			{
			av="����";
			}
			ok=m.oknum;
			un=m.username;
			if(m.job==0) {
				jb="ѧ��";
			}
			else{
				jb="��ʦ";
			}
			ne=m.name;
			if(m.sex==0) {
				sx="��";
			}
			else{
				sx="Ů";
			}
			tl=m.tel;
			gd=convertGrades(m.grade);
			ss=convertSubjects(m.subject);
			tm=convertTimes(m.time);
			pl=convertPlace(m.place);
			pr=convertPrice(m.price);
			man_out mo=new man_out(un,jb,ne,sx,gd,ss,tl,pr,av,ok,tm,pl);
			ans.add(mo);
		}
		return ans;	
	}
	private String convertPrice(int price2) {
		String ans=new String();
		if (price2==1)
			ans="50Ԫ����";
		else if (price2==2)
			ans="50~100Ԫ";
		else if (price2==3)
			ans="100~150Ԫ";
		else if (price2==4)
			ans="150~200Ԫ";
		else if(price2==5)
			ans="200Ԫ����";
		return ans;
	}
		private String convertPlace(int place2) {
			String ans=new String();
			if (place2==1)
				ans="��������";
			else if (place2==2)
				ans="���������";
			else if (place2==3)
				ans="������";
			else if (place2==4)
				ans="�׸���";
			else if (place2==5)
				ans="˫Ѽɽ��";
			else if (place2==6)
				ans="������";
			else if (place2==7)
				ans="������";
			else if (place2==8)
				ans="��ľ˹��";
			else if (place2==9)
				ans="��̨����";
			else if (place2==10)
				ans="ĵ������";
			else if (place2==11)
				ans="�ں���";
			else if (place2==12)
				ans="�绯��";
			else  if (place2==13) {
				ans="���˰������";
			}
			return ans;
		}
		private String convertTimes(String time2) {
			String ans="";
			String[] dic= {"ѧУ������","ѧУ����ĩ����","ѧУ����ĩ����","ѧУ����ĩ����","���������","���������","���������"};
			char[] temp=time2.toCharArray();
			for(int i=0;i<7;i++) {
				if(temp[i]=='1') {
					ans+=dic[i];
				}
			}
			return ans;
		}
	private String convertSubjects(String subject) {
		String ans="";
		String[] dic= {"��","��","��","��","��","��","ʷ","��","��"};
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
		String[] dic= {"Сһ","С��","С��","С��","С��","С��","��һ","����","����","��һ","�߶�","����"};
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
	private String Fill_Time(int[] p) {
		char []ans;
		ans=new char[]{'0','0','0','0','0','0','0'};
		for(int i=0;i<p.length;i++)
		{
			ans[p[i]]='1';
		}
		return String.valueOf(ans);
	}
	public String search() {
		jb=job;
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		originuser=(String)session.get("obj1");
		Man temp=new Man(originuser,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		temp=DbTools.Fill(temp);
		jbself=temp.job;
		if (username.equals(""))
			username=null;
		if (name.equals(""))
			name=null;
		person=new Man(username,job,name,sex,null,Fill_Grades(grades),Fill_Subjects(subjects),null,0,0,0,0,0,-1,Fill_Time(time),place,0);
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public int getJb() {
		return jb;
	}
	public void setJb(int jb) {
		this.jb = jb;
	}
	public int getJbself() {
		return jbself;
	}
	public void setJbself(int jbself) {
		this.jbself = jbself;
	}
}
