  package backport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumnModel;
public class DbTools {
	private static int M=20;
	public static void Add(Man m)
	{
	Connection connect=null;
	PreparedStatement Statement=null;
	ResultSet rs = null;
	String MES="MES";
	String PJ="PJ";
	String JD="JD";
	try {
		Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Success loading Mysql Driver1!");
	    }
	catch (Exception e) {
	         System.out.print("Error loading Mysql Driver!");
	         e.printStackTrace();
	    }
	try {
	     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
	     Statement=connect.prepareStatement("SELECT * FROM user where username='MMMM'");
	     rs =Statement.executeQuery();
	     rs.next();
	     m.MESID=rs.getInt(9);
	     m.PJID=m.MESID;
	   }catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(rs!=null)
                {
                    rs.close();
                }
                if(Statement!=null)
                {
                    Statement.close();
                }
                if(connect!=null)
                {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	try {
	     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
	     Statement=connect.prepareStatement("update user set MESID = ? where username='MMMM'");
	     Statement.setLong(1,m.PJID+1);
	     Statement.executeUpdate();
	   }catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            try {
                if(Statement!=null)
                {
                    Statement.close();
                }
                if(connect!=null)
                {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	try {
		Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Success loading Mysql Driver!");
	    }
	catch (Exception e) {
	         System.out.print("Error loading Mysql Driver!");
	         e.printStackTrace();
	    }
	try {
	     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
	     Statement=connect.prepareStatement("INSERT INTO user VALUES"
	     		+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	     Statement.setString(1,m.username);
	     Statement.setLong(2,m.job);
	     Statement.setString(3,m.name);
	     Statement.setLong(4,m.sex);
	     Statement.setString(5,m.pwd);
	     Statement.setString(6,m.grade);
	     Statement.setString(7,m.subject);
	     Statement.setString(8,m.tel);
	     Statement.setLong(9,m.MESID);
	     Statement.setLong(10,m.PJID);
	     Statement.setLong(11,0);
	     Statement.setLong(12,m.price);
	     Statement.setLong(13,m.avestar);
	     Statement.setLong(14,m.oknum);
	     Statement.setString(15,m.time);
	     Statement.setLong(16,m.place);
	     Statement.setLong(17,m.starnum);
	     Statement.executeUpdate();
	   }catch (SQLException e) {
           e.printStackTrace();
       }finally
       {
           try {
               if(Statement!=null)
               {
            	   Statement.close();
               }
               if(connect!=null)
               {
                   connect.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
	MES+=String.valueOf(m.MESID);
	PJ+=String.valueOf(m.PJID);
	JD+=String.valueOf(m.PJID);
	CreateTable(MES,PJ,JD);
	 }
	private static void CreateTable(String mES,String pJ,String JD) {
		Connection connect=null;
		PreparedStatement Statement=null;
			try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
		     Statement=connect.prepareStatement("create table " + mES +" (pos int,frm varchar(20),DTA varchar(20),STR varchar(1000),BR varchar(100),readed int);");
		     System.out.println("create table " + mES +" (pos int,person varchar(20),DTA varchar(20),STR varchar(1000),BR varchar(100),readed int)");
		     Statement.executeUpdate();
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                {
	                    Statement.close();
	                }
	                if(connect!=null)
	                {
	                    connect.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		try
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
			Statement=connect.prepareStatement("create table  " + pJ +" (frm varchar(20),mes varchar(40),DTA varchar(20),proc int,star int,judgement varchar(2000));");
			//System.out.println("create table  " + pJ +" (DTA varchar(20),STR varchar(2000),star int)");
			Statement.executeUpdate();
		}
		catch (SQLException e)
		{
            e.printStackTrace();
	    }
		try
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
			Statement=connect.prepareStatement("create table  " + JD +" (frm varchar(20),DTA varchar(20),STR varchar(2000),star int,pos int);");
			//System.out.println("create table  " + JD +" (frm varchar(20),DTA varchar(20),STR varchar(2000),star int,pos int);");
			Statement.executeUpdate();
		}
		catch (SQLException e)
		{
            e.printStackTrace();
	    }
		finally
        {
            try {
                if(Statement!=null)
                {
                    Statement.close();
                }
                if(connect!=null)
                {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	public static Man Fill(Man m){
		Man ans=null;
		List<Man> temp=new ArrayList<Man>();
		temp=Querry(m);
		if(temp==null){
			return null;
		}
		else
		{
			for(Man m1:temp) {
				ans=new Man(m1.username,m1.job,m1.name,m1.sex,m1.pwd,m1.grade,m1.subject,m1.tel,m1.MESID,m1.PJID,m1.unread,m1.price,m1.avestar,m1.oknum,m1.time,m1.place,m.starnum);
			}
		}
		return ans;
	}
	public static ArrayList<mes> QuerryMes(int ps,int rd,int MSID){
		ArrayList<mes> ans=new ArrayList<mes>();
		int pos;
		String person;
		String DTA;
		String STR;
		int readed;
		String brief=new String();
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs = null;
		String temp="";
		if(ps==0) {
			temp="pos=0";
		}
		else if(rd==1) {
			temp="readed=1";
		}
		else if(rd==0) {
			temp="readed=0";
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("SELECT * FROM" + " mes"+String.valueOf(MSID)+" where "+temp+" ORDER BY readed ASC");
		     System.out.println("SELECT * FROM" + " mes"+String.valueOf(MSID)+" where "+temp+" ORDER BY readed ASC");
		     rs =Statement.executeQuery();
		     while(rs.next()) {
		    	 pos=rs.getInt("pos");
		    	 person=rs.getString("frm");
		    	 DTA=rs.getString("dta");
		    	 STR=rs.getString("str");
		    	 readed=rs.getInt("readed");
		    	 brief=rs.getString("BR");
		    	 mes m=new mes(pos,person,DTA,STR,readed,brief);
		    	 ans.add(m);
		     }
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(rs!=null)
	                {
	                    rs.close();
	                }
	                if(Statement!=null)
	                {
	                    Statement.close();
	                }
	                if(connect!=null)
	                {
	                    connect.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		return ans;
	}
	public static ArrayList<Man> Querry(Man m)
	{
		StringBuffer querrying_order1;
		StringBuffer querrying_order2;
		querrying_order1=new StringBuffer();
		querrying_order1.append("SELECT * from user where");
//-------------------------------------------------------		
		querrying_order2=new StringBuffer();
		if (m.username!=null)
		{
			querrying_order2.append(" username='");
			querrying_order2.append(m.username+"' AND");
		}
		if (m.job!=2)	
		{
			querrying_order2.append(" job='");
			querrying_order2.append(String.valueOf(m.job)+"' AND");
		}
		if (m.name!=null)
		{
			querrying_order2.append(" name='");
			querrying_order2.append(m.name+"' AND");
		}
		if (m.sex!=2)	
		{
			querrying_order2.append(" sex='");
			querrying_order2.append(String.valueOf(m.sex)+"' AND");
		}
		if (m.price!=0)
		{
			querrying_order2.append(" price='");
			querrying_order2.append(m.price+"' AND");
		}
		if (m.place!=0)
		{
			querrying_order2.append(" place='");
			querrying_order2.append(m.place+"' AND");
		}
		if (m.grade!=null)
		{
			querrying_order2.append(" grade LIKE '");
			querrying_order2.append(Turn_Grade(m.grade)+"' AND");
		}
		if (m.time!=null)
		{
			querrying_order2.append(" time LIKE '");
			querrying_order2.append(Turn_Time(m.time)+"' AND");
		}
		if (m.subject!=null)
		{
			querrying_order2.append(" subject LIKE '");
			querrying_order2.append(Turn_Subject(m.subject)+"' AND");
		}
		querrying_order1.append(querrying_order2.substring(0, querrying_order2.length()-4)+";");
//------------------------------------------------------
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs = null;
		ArrayList<Man> result = new ArrayList<Man>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement(querrying_order1.toString());
		     rs =Statement.executeQuery();
		     while(rs.next())
		     {
		    	 String username=rs.getString("username");
				 int job=rs.getInt("job");
				 String name=rs.getString("name");
				 int sex=rs.getInt("sex");
				 String pwd=rs.getString("pwd");
				 String grade=rs.getString("grade");
				 String subject=rs.getString("subject");
				 String tel=rs.getString("tel");
				 int MESID=rs.getInt("MESID");
				 int PJID=rs.getInt("PJID");
				 int unread=rs.getInt("unread");
				 int price=rs.getInt("price");
				 int avestar=rs.getInt("avestar");
				 int oknum=rs.getInt("oknum");
				 String time=rs.getString("time");
				 int place=rs.getInt("place");
				 int starnum=rs.getInt("starnum");
				 Man m0=new Man(username,job,name,sex,pwd,grade,subject,tel,MESID,PJID,unread,price,avestar,oknum,time,place,starnum);
				 result.add(m0);
		     }
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(rs!=null)
                {
                    rs.close();
                }
                if(Statement!=null)
                {
                    Statement.close();
                }
                if(connect!=null)
                {
                    connect.close();
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
//-------------------------------------------------------------
		return result;
	}
	public static ArrayList<Man> Match(Man m)//目前无法加入价位匹配 --时间匹配--地点匹配
	{
		StringBuffer matching_order1;
		StringBuffer matching_order2;
		StringBuffer matching_order3;
		StringBuffer matching_order4;
		matching_order1=new StringBuffer();
		matching_order1.append("SELECT DISTINCT * from user where");
//-------------------------------------------------------		
		matching_order2=new StringBuffer();
		matching_order3=new StringBuffer();
		matching_order4=new StringBuffer();
		matching_order3.append(") AND (");
		matching_order4.append(") AND (");
		char []list_grade;
		char []list_subject;
		char []list_time;
		char []temp;
		list_grade=m.grade.toCharArray();
		list_subject=m.subject.toCharArray();
		list_time=m.time.toCharArray();
		if (m.job==0)
		{
			matching_order2.append(" job=1 AND price<=");
			matching_order2.append(m.price+" AND place=");
		}
		else
		{
			matching_order2.append(" job=0 AND price>=");
			matching_order2.append(m.price+" AND place=");
		}
		matching_order2.append(+m.place+" AND (");
		for (int i=0;i<12;i++)
		{
			temp=new char[] {'_','_','_','_','_','_','_','_','_','_','_','_'};
			if (list_grade[i]=='1')
			{
				temp[i]='1';
				matching_order2.append(" grade LIKE '");
				matching_order2.append(String.valueOf(temp)+"' OR");
			}
		}
		matching_order1.append(matching_order2.substring(0, matching_order2.length()-3));
		for (int i=0;i<9;i++)
		{
			temp=new char[] {'_','_','_','_','_','_','_','_','_'};
			if (list_subject[i]=='1')
			{
				temp[i]='1';
				matching_order3.append(" subject LIKE '");
				matching_order3.append(String.valueOf(temp)+"' OR");
			}
		}
		matching_order1.append(matching_order3.substring(0, matching_order3.length()-3));
		for (int i=0;i<6;i++)
		{
			temp=new char[] {'_','_','_','_','_','_','_'};
			if (list_time[i]=='1')
			{
				temp[i]='1';
				matching_order4.append(" time LIKE '");
				matching_order4.append(String.valueOf(temp)+"' OR");
			}
		}
		matching_order1.append(matching_order4.substring(0, matching_order4.length()-3)+");");
		System.out.println(matching_order1);
//------------------------------------------------------
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs = null;
		ArrayList<Man> result = new ArrayList<Man>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement(matching_order1.toString());
		     rs =Statement.executeQuery();
		     while(rs.next())
		     {
		    	 String username=rs.getString("username");
				 int job=rs.getInt("job");
				 String name=rs.getString("name");
				 int sex=rs.getInt("sex");
				 String pwd=rs.getString("pwd");
				 String grade=rs.getString("grade");
				 String subject=rs.getString("subject");
				 String tel=rs.getString("tel");
				 int MESID=rs.getInt("MESID");
				 int PJID=rs.getInt("PJID");
				 int unread=rs.getInt("unread");
				 int price=rs.getInt("price");
				 int avestar=rs.getInt("avestar");
				 int oknum=rs.getInt("oknum");
				 String time=rs.getString("time");
				 int place=rs.getInt("place");
				 int starnum=rs.getInt("starnum");
				 Man m0=new Man(username,job,name,sex,pwd,grade,subject,tel,MESID,PJID,unread,price,avestar,oknum,time,place,starnum);
				 result.add(m0);
		     }
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(rs!=null)
                    rs.close();
                if(Statement!=null)
                    Statement.close();
                if(connect!=null)
                    connect.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
//-------------------------------------------------------------
		return result;
	}
	private static StringBuffer Turn_Time(String time)
	{
		StringBuffer result;
		char []temp;
		result=new StringBuffer();
		temp=time.toCharArray();
		System.out.println(time);
		for (int i=0;i<7;i++)
		{
			System.out.print(i+" ");
			System.out.println(temp[i]+" ");
			if (temp[i]=='1')
				result.append("1");
			else
				result.append("_");
		}
		System.out.println(result);
		return result;
	}
	private static StringBuffer Turn_Grade(String grade)
	{
		StringBuffer result;
		char []temp;
		result=new StringBuffer();
		temp=grade.toCharArray();
		System.out.println(grade);
		for (int i=0;i<12;i++)
		{
			System.out.print(i+" ");
			System.out.println(temp[i]+" ");
			if (temp[i]=='1')
				result.append("1");
			else
				result.append("_");
		}
		System.out.println(result);
		return result;
	}
	private static StringBuffer Turn_Subject(String subject)
	{
		StringBuffer result;
		char []temp;
		result=new StringBuffer();
		temp=subject.toCharArray();
		for (int i=0;i<9;i++)
		{
			if (temp[i]=='1')
				result.append("1");
			else
				result.append("_");
		}
		return result;
	}
	public static void Add_Message(String sender,String addressee,String date,String message)
	{
		StringBuffer short_message;
		String temp;
		Man m_sender;
		Man m_addressee;
		Man temp_man;
		int unread;
		temp_man=new Man(sender,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		m_sender=Querry(temp_man).get(0);
		temp_man=new Man(addressee,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		m_addressee=Querry(temp_man).get(0);
		unread=m_addressee.unread+1;
		
		short_message=new StringBuffer();
		short_message.append(message);
		if (short_message.length()>M)
			temp=short_message.substring(0,M);
		else
			temp=short_message.toString();
		Connection connect=null;
		PreparedStatement Statement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("insert into mes"+m_sender.MESID+" values(?,?,?,?,?,?);");
		     Statement.setLong(1,0);
		     Statement.setString(2,addressee);
		     Statement.setString(3,date);
		     Statement.setString(4,message);
		     Statement.setString(5,temp);
		     Statement.setLong(6,2);
		     Statement.executeUpdate();
		     
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("insert into mes"+m_addressee.MESID+" values(?,?,?,?,?,?);");
		     Statement.setLong(1,1);
		     Statement.setString(2,sender);
		     Statement.setString(3,date);
		     Statement.setString(4,message);
		     Statement.setString(5,temp);
		     Statement.setLong(6,0);
		     Statement.executeUpdate();
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("update user set unread=? where username=?;");
		     Statement.setLong(1,unread);
		     Statement.setString(2,addressee);
		     Statement.executeUpdate();
		     
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(Statement!=null)
                    Statement.close();
                if(connect!=null)
                    connect.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
	}
	public static void Delete_Message(int MESID,String frm,String date)
	{
		Connection connect=null;
		PreparedStatement Statement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
	    }
		try
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		    Statement=connect.prepareStatement("delete from mes"+MESID+" where frm=? and DTA=?;");
		    Statement.setString(1,frm);
		    Statement.setString(2,date);
		    Statement.executeUpdate();
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(Statement!=null)
                    Statement.close();
                if(connect!=null)
                    connect.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
	}
	public static mes Querry_Information(int MESID,String person,String date,int refesh)
	{
		mes result;
		StringBuffer querrying_order,refesh_order;
		querrying_order=new StringBuffer();
		querrying_order.append("SELECT * from mes"+MESID);
		querrying_order.append(" where frm='"+person);
		querrying_order.append("' and DTA='"+date);
		querrying_order.append("';");
		
		refesh_order=new StringBuffer();
		refesh_order.append("update mes"+MESID);
		refesh_order.append(" set readed=1 where frm=? and DTA=?;");
		
		result=null;
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement(querrying_order.toString());
		     rs =Statement.executeQuery();
		     while(rs.next())
		     {
		    	 result=new mes(rs.getInt("pos"),rs.getString("frm"),rs.getString("DTA"),rs.getString("STR"),rs.getInt("readed"),rs.getString("BR"));
		     }
		     
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     if (refesh==1)
			 {
			     Statement=connect.prepareStatement(refesh_order.toString());
			     Statement.setString(1,person);
			     Statement.setString(2,date);
			     Statement.executeUpdate();
			 }
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(rs!=null)
                    rs.close();
                if(Statement!=null)
                    Statement.close();
                if(connect!=null)
                    connect.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
//-------------------------------------------------------------
		return result;
	}
	public static void Update_Information(Man update)
	{
		Connection connect=null;
		PreparedStatement Statement=null;
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
	         System.out.print("Error loading Mysql Driver!");
	         e.printStackTrace();
		}
		try
		{
			if(!update.grade.equals("000000000000"))
			{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("update user set grade=? where username=?;");
		     Statement.setString(1, update.grade);
		     Statement.setString(2, update.username);
		     Statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
	    }
		try
		{
			if(!update.subject.equals("000000000")) {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("update user set subject=? where username=?;");
		     Statement.setString(1, update.subject);
		     Statement.setString(2, update.username);
		     Statement.executeUpdate();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     if (!update.tel.equals(""))
		     {
		    	 Statement=connect.prepareStatement("update user set tel=? where username=?;");
		    	 Statement.setString(1, update.tel);
			     Statement.setString(2, update.username);
			     Statement.executeUpdate();
		     }
		}catch (SQLException e)
		{
			e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     if (!update.pwd.equals(""))
		     {
		    	 Statement=connect.prepareStatement("update user set pwd=? where username=?;");
		    	 Statement.setString(1, update.pwd);
			     Statement.setString(2, update.username);
			     Statement.executeUpdate();
		     }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     if (update.price!=0)
		     {
		    	 Statement=connect.prepareStatement("update user set price=? where username=?;");
		    	 Statement.setLong(1, update.price);
			     Statement.setString(2, update.username);
			     Statement.executeUpdate();
		     }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     if (update.place!=0)
		     {
		    	 Statement=connect.prepareStatement("update user set place=? where username=?;");
		    	 Statement.setLong(1, update.place);
			     Statement.setString(2, update.username);
			     Statement.executeUpdate();
		     }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     if (!update.time.equals("0000000"))
		     {
		    	 Statement=connect.prepareStatement("update user set time=? where username=?;");
		    	 Statement.setString(1, update.time);
			     Statement.setString(2, update.username);
			     Statement.executeUpdate();
		     }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
	    }
		finally
        {
            try {
                if(Statement!=null)
                    Statement.close();
                if(connect!=null)
                    connect.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
	}
	public static void Rsfresh_Man(String originuser,int i,int mod) {
		Man man=new Man(originuser,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		int num=0;
		for(Man m: Querry(man)) {
			if(mod==0) {
			num=m.unread+i;
			}
			else if(mod==1){
			num=m.avestar+i;	
			}
			else if(mod==2) {
			num=m.oknum+i;
			}
			else if(mod==3) {
			num=m.starnum+i;
			}
		}
		Connection connect=null;
		PreparedStatement Statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     if(mod==0)
		     {
		     Statement=connect.prepareStatement("update user set unread= ? where username=?");
		     }
		     else if(mod==1) {
		    	 Statement=connect.prepareStatement("update user set avestar= ? where username=?");	 
		     }
		     else if(mod==2) {
		    	 Statement=connect.prepareStatement("update user set oknum= ? where username=?");	 
		     }
		     else if(mod==3) {
		    	 Statement=connect.prepareStatement("update user set starnum= ? where username=?");	 
		     }
		     Statement.setLong(1, num);
		     Statement.setString(2, originuser);
		     Statement.executeUpdate();
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		
	}
	public static void Add_SysPj(syspj ipt) {
		Connection connect=null;
		PreparedStatement Statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("insert into syspj values(?,?,?)");
		     Statement.setString(1,ipt.STR);
		     Statement.setString(2,ipt.DTA);
		     Statement.setString(3,ipt.username);
		     Statement.executeUpdate();
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	public static void Add_pj(pj p1,String tag) {
		Connection connect=null;
		PreparedStatement Statement=null;
		Man tempman=new Man(tag,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		int PJID=Querry(tempman).get(0).PJID;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("insert into pj"+PJID+" values(?,?,?,?,?,?)");
		     Statement.setString(1,p1.frm);
		     Statement.setString(2,p1.mes);
		     Statement.setString(3,p1.DTA);
		     Statement.setLong(4,p1.proc);
		     Statement.setLong(5,p1.star);
		     Statement.setString(6,p1.judgement);
		     Statement.executeUpdate();
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		
	}
	public static ArrayList<pj> QuerryPj(int i, int mESID) {
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs=null;
		ArrayList<pj> ans=new ArrayList<pj>();
		String frm;
		String mes;
		String DTA;
		int proc;
		int star;
		String judgement;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("SELECT * FROM" + " PJ"+String.valueOf(mESID)+" where proc=?");
		     Statement.setLong(1,i);
		     rs =Statement.executeQuery();
		     while(rs.next()) {
		    	 frm=rs.getString("frm");
		    	 mes=rs.getString("mes");
		    	 DTA=rs.getString("DTA");
		    	 proc=rs.getInt("proc");
		    	 star=rs.getInt("star");
		    	 judgement=rs.getString("judgement");
		    	 pj p=new pj(frm,mes,DTA,proc,star,judgement);
		    	 ans.add(p);
		     }
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(rs!=null)
	                    rs.close();
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		return ans;
	}
	public static void SetPjInt(String username,String frm,String DTA,int pos,int dat) {
		String ope;
		Connection connect=null;
		PreparedStatement Statement=null;
		Man tempman=new Man(username,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		int PJID=Querry(tempman).get(0).PJID;
		if(pos==4) {
			ope=" proc= ";
		}
		else {
			ope=" star= ";
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("update Pj"+PJID+ " set "+ope+" ? where frm=? and DTA=?");
		     Statement.setLong(1,dat);
		     Statement.setString(2,frm);
		     Statement.setString(3,DTA);
		     Statement.executeUpdate();
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	public static boolean CheckPjByusername(String frm, String to) {
		int flag=0;
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs=null;
		Man tempman=new Man(frm,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		int PJID=Querry(tempman).get(0).PJID;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("select DTA from pj"+PJID+" where frm=?");
		     Statement.setString(1,to);
		     rs=Statement.executeQuery();
		     while(rs.next()) {
		    	 flag=1;
		     }
		   }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		if(flag==1)
			return true;
		return false;
	}
	public static void Delete_pj(String originuser, String frm) {
		Connection connect=null;
		PreparedStatement Statement=null;
		Man tempman=new Man(originuser,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		int PJID=Querry(tempman).get(0).PJID;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		    }
		catch (Exception e) {
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
		    }
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement("delete from pj"+PJID+" where frm=?");
		     Statement.setString(1,frm);
		     Statement.executeUpdate();
		     }catch (SQLException e) {
	            e.printStackTrace();
	        }finally
	        {
	            try {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
	public static ArrayList<Ass> Querry_Assess(String frm,String others,int pos)
	{
		ArrayList<Ass> result = new ArrayList<Ass>();
		StringBuffer querrying_order;
		Man temp_man,m_frm;
		temp_man=new Man(frm,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		m_frm=Querry(temp_man).get(0);
		querrying_order=new StringBuffer();
		querrying_order.append("SELECT * from JD"+m_frm.PJID);
		querrying_order.append(" where pos="+pos);
		if (others!=null && !others.equals(""))
		{
			querrying_order.append(" and frm='"+others);
			querrying_order.append("';");
		}
		else
			querrying_order.append(";");
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		         System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
		         System.out.print("Error loading Mysql Driver!");
		         e.printStackTrace();
	    }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement=connect.prepareStatement(querrying_order.toString());
		     rs =Statement.executeQuery();
		     while(rs.next())
		     {
		    	 String person=rs.getString("frm");
		    	 String DTA=rs.getString("DTA");
				 String STR=rs.getString("STR");
				 int star=rs.getInt("star");
				 Ass m0=new Ass(person,DTA,STR,star,pos);
				 result.add(m0);
		     }
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(rs!=null)
                    rs.close();
                if(Statement!=null)
                    Statement.close();
                if(connect!=null)
                    connect.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
		return result;
	}
	public static String Add_Update_Assess(String frm,Ass assess)
	{
		ArrayList<Ass> tmp;
		Man m_frm,m_others,temp_man;
		temp_man=new Man(frm,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		m_frm=Querry(temp_man).get(0);
		temp_man=new Man(assess.frm,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		m_others=Querry(temp_man).get(0);
		tmp=Querry_Assess(frm,assess.frm,assess.pos);
		
		Connection connect=null;
		PreparedStatement Statement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
			System.out.print("Error loading Mysql Driver!");
		    e.printStackTrace();
	    }
		if (tmp.size()!=0)
		{
			System.out.println(tmp.get(0).star);
		    DbTools.Rsfresh_Man(assess.frm,assess.star-tmp.get(0).star,1);
			try
			{
			    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
			    Statement=connect.prepareStatement("update JD"+m_frm.PJID+" set DTA=?,STR=?,star=? where frm=? AND pos=?;");
			    Statement.setString(1,assess.DTA);
			    Statement.setString(2,assess.STR);
			    Statement.setLong(3,assess.star);
			    Statement.setString(4,assess.frm);
			    Statement.setLong(5,1);
			    Statement.executeUpdate();
			}
			catch (SQLException e)
			{
	            e.printStackTrace();
	        }
			try
			{
			    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
			    Statement=connect.prepareStatement("update JD"+m_others.PJID+" set DTA=?,STR=?,star=? where frm=? AND pos=?;");
			    Statement.setString(1,assess.DTA);
			    Statement.setString(2,assess.STR);
			    Statement.setLong(3,assess.star);
			    Statement.setString(4,frm);
			    Statement.setLong(5,0);
			    Statement.executeUpdate();
			}
			catch (SQLException e)
			{
	            e.printStackTrace();
	        }
			finally
	        {
	            try
	            {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            }
	            catch (SQLException e)
	            {
	                e.printStackTrace();
	            }
	        }
		}
		else
		{
			DbTools.Rsfresh_Man(assess.frm,assess.star,1);
			DbTools.Rsfresh_Man(assess.frm,1,3);
			try
			{
			    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
			    Statement=connect.prepareStatement("insert into JD"+m_frm.PJID+" values(?,?,?,?,?);");
			    Statement.setString(1,assess.frm);
			    Statement.setString(2,assess.DTA);
			    Statement.setString(3,assess.STR);
			    Statement.setLong(4,assess.star);
			    Statement.setLong(5,1);
			    Statement.executeUpdate();
			}
			catch (SQLException e)
			{
	            e.printStackTrace();
	        }
			try
			{
			    connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
			    Statement=connect.prepareStatement("insert into JD"+m_others.PJID+" values(?,?,?,?,?);");
			    Statement.setString(1,frm);
			    Statement.setString(2,assess.DTA);
			    Statement.setString(3,assess.STR);
			    Statement.setLong(4,assess.star);
			    Statement.setLong(5,0);
			    Statement.executeUpdate();
			}
			catch (SQLException e)
			{
	            e.printStackTrace();
	        }
			finally
	        {
	            try
	            {
	                if(Statement!=null)
	                    Statement.close();
	                if(connect!=null)
	                    connect.close();
	            }
	            catch (SQLException e)
	            {
	                e.printStackTrace();
	            }
	        }
		}
		return "SUCCESS";
	}
	public static String Delete_Assess(String frm,String others)
	{
		Ass a_others;
		Man m_frm, m_others, temp_man;
		temp_man=new Man(frm,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		m_frm=Querry(temp_man).get(0);
		temp_man=new Man(others,2,null,2,null,null,null,null,0,0,0,0,0,-1,null,0,0);
		m_others=Querry(temp_man).get(0);
		Connection connect=null;
		PreparedStatement Statement=null;
		a_others=DbTools.Querry_Assess(frm,others,1).get(0);
		Rsfresh_Man(others,-1*a_others.star,1);
		Rsfresh_Man(others,-1,3);
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Mysql Driver1!");
		}
		catch (Exception e)
		{
		    System.out.print("Error loading Mysql Driver!");
		    e.printStackTrace();
	    }
		try
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		    Statement=connect.prepareStatement("delete from JD"+m_frm.PJID+" where pos=? and frm=?;");
		    Statement.setLong(1,1);
		    Statement.setString(2,others);
		    Statement.executeUpdate();
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		try
		{
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		    Statement=connect.prepareStatement("delete from JD"+m_others.PJID+" where pos=? and frm=?;");
		    Statement.setLong(1,0);
		    Statement.setString(2,frm);
		    Statement.executeUpdate();
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(Statement!=null)
                    Statement.close();
                if(connect!=null)
                    connect.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
		return "SUCCESS";
	}
}
