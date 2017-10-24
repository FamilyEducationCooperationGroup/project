package backport;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
public class Action_Show extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int jb;
	public String originuser;
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
	public int getJb() {
		return jb;
	}
	public void setJb(int jb) {
		this.jb = jb;
	}
	public ArrayList<man_out> getResult() {
		return result;
	}
	public void setResult(ArrayList<man_out> result) {
		this.result = result;
	}
	public String show()
	{
		Man m=new Man(null,jb,null,2,null,null,null,null,0,0,0);
		result=convertResult(DbTools.Querry(m));
		return "SUCCESS";
	}
	public String getOriginuser() {
		return originuser;
	}
	public void setOriginuser(String originuser) {
		this.originuser = originuser;
	}
}
