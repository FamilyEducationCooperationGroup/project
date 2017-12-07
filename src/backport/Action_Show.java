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
			String pr;
			String av;
			int ok;
			String tm;
			String pl;
			if(m.starnum!=0)
			{
			av=String.format("%.1f",m.avestar*1.0/m.starnum);
			}
			else
			{
			av="暂无";
			}
			ok=m.oknum;
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
			ans="50元以下";
		else if (price2==2)
			ans="50~100元";
		else if (price2==3)
			ans="100~150元";
		else if (price2==4)
			ans="150~200元";
		else if(price2==5)
			ans="200元以上";
		return ans;
	}
	private String convertPlace(int place2) {
		String ans=new String();
		if (place2==12)
			ans="哈尔滨市";
		else if (place2==1)
			ans="齐齐哈尔市";
		else if (place2==2)
			ans="鸡西市";
		else if (place2==3)
			ans="鹤岗市";
		else if (place2==4)
			ans="双鸭山市";
		else if (place2==5)
			ans="大庆市";
		else if (place2==6)
			ans="伊春市";
		else if (place2==7)
			ans="佳木斯市";
		else if (place2==8)
			ans="七台河市";
		else if (place2==9)
			ans="牡丹江市";
		else if (place2==10)
			ans="黑河市";
		else if (place2==11)
			ans="绥化市";
		else if(place2==13)
			ans="大兴安岭地区";
		return ans;
	}
	private String convertTimes(String time2) {
		String ans="";
		String[] dic= {"学校日晚上","学校日周末上午","学校日周末下午","学校日周末晚上","寒暑假上午","寒暑假下午","寒暑假晚上"};
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
		Man m=new Man(null,jb,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
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
