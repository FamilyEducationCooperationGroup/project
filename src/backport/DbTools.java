package backport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DbTools {
	public static void Add(Man m)
	{
	Connection connect=null;
	PreparedStatement Statement=null;
	ResultSet rs = null;
	String MES="MES";
	String PJ="PJ";
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
	     		+ "(?,?,?,?,?,?,?,?,?,?,?)");
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
	CreateTable(MES,PJ);
	 }
	private static void CreateTable(String mES,String pJ) {
		Connection connect=null;
		PreparedStatement Statement=null;
		
		try {
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
		     Statement=connect.prepareStatement("create table " + mES +" (frm varchar(20),DTA varchar(20),STR varchar(1000))");
		     System.out.println("create table " + mES +" (pos int,person varchar(20),DTA varchar(20),STR varchar(1000),readed int)");
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
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false","root","1234");
		     Statement=connect.prepareStatement("create table  " + pJ +" (DTA varchar(20),STR varchar(2000),star int)");
		     System.out.println("create table  " + pJ +" (DTA varchar(20),STR varchar(2000),star int)");
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
				ans=new Man(m1.username,m1.job,m1.name,m1.sex,m1.pwd,m1.grade,m1.subject,m1.tel,m1.MESID,m1.PJID,m.unread);
			}
		}
		return ans;
	}
	public static List<mes> QuerryMes(int MSID){
		List<mes> ans=new ArrayList<mes>();
		int pos;
		String person;
		String DTA;
		String STR;
		int readed;
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs = null;
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
		     Statement=connect.prepareStatement("SELECT * FROM" + " 'mes"+String.valueOf(MSID)+"'"+" ORDER BY readed ASC");
		     rs =Statement.executeQuery();
		     while(rs.next()) {
		    	 pos=rs.getInt("pos");
		    	 person=rs.getString("person");
		    	 DTA=rs.getString("dta");
		    	 STR=rs.getString("str");
		    	 readed=rs.getInt("readed");
		    	 mes m=new mes(pos,person,DTA,STR,readed);
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
		StringBuffer querying_condition1;
		StringBuffer querying_condition2;
		querying_condition1=new StringBuffer();
		querying_condition1.append("SELECT * from user where");
//-------------------------------------------------------		
		querying_condition2=new StringBuffer();
		if (m.username!=null)
		{
			querying_condition2.append(" username='");
			querying_condition2.append(m.username+"' AND");
		}
		if (m.job!=2)	
		{
			querying_condition2.append(" job='");
			querying_condition2.append(String.valueOf(m.job)+"' AND");
		}
		if (m.name!=null)
		{
			querying_condition2.append(" name='");
			querying_condition2.append(m.name+"' AND");
		}
		if (m.sex!=2)	
		{
			querying_condition2.append(" sex='");
			querying_condition2.append(String.valueOf(m.sex)+"' AND");
		}
		if (m.pwd!=null)
		{
			querying_condition2.append(" pwd='");
			querying_condition2.append(m.pwd+"' AND");
		}
		if (m.grade!=null)
		{
			querying_condition2.append(" grade LIKE '");
			querying_condition2.append(Turn_Grade(m.grade)+"' AND");
		}
		if (m.subject!=null)
		{
			querying_condition2.append(" subject LIKE '");
			querying_condition2.append(Turn_Subject(m.subject)+"' AND");
		}
		querying_condition1.append(querying_condition2.substring(0, querying_condition2.length()-4)+";");
		System.out.println(querying_condition1);
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
		     Statement=connect.prepareStatement(querying_condition1.toString());
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
				 Man m0=new Man(username,job,name,sex,pwd,grade,subject,tel,MESID,PJID,unread);
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
	public static ArrayList<Man> Match(Man m)
	{
		StringBuffer querying_condition1;
		StringBuffer querying_condition2;
		StringBuffer querying_condition3;
		querying_condition1=new StringBuffer();
		querying_condition1.append("SELECT DISTINCT * from user where");
//-------------------------------------------------------		
		querying_condition2=new StringBuffer();
		querying_condition3=new StringBuffer();
		querying_condition3.append(") AND (");
		char []list_grade;
		char []list_subject;
		char []temp;
		list_grade=m.grade.toCharArray();
		list_subject=m.grade.toCharArray();
		if (m.job==0)
			querying_condition2.append(" job=1 AND (");
		else
			querying_condition2.append(" job=0 AND (");
		for (int i=0;i<12;i++)
		{
			temp=new char[] {'_','_','_','_','_','_','_','_','_','_','_','_'};
			if (list_grade[i]=='1')
			{
				temp[i]='1';
				querying_condition2.append(" grade LIKE '");
				querying_condition2.append(String.valueOf(temp)+"' OR");
			}
		}
		querying_condition1.append(querying_condition2.substring(0, querying_condition2.length()-3));
		for (int i=0;i<9;i++)
		{
			temp=new char[] {'_','_','_','_','_','_','_','_','_'};
			if (list_subject[i]=='1')
			{
				temp[i]='1';
				querying_condition3.append(" subject LIKE '");
				querying_condition3.append(String.valueOf(temp)+"' OR");
			}
		}
		querying_condition1.append(querying_condition3.substring(0, querying_condition3.length()-3)+");");
		System.out.println(querying_condition1);
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
		     Statement=connect.prepareStatement(querying_condition1.toString());
		     System.out.println(querying_condition1.toString());
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
				 Man m0=new Man(username,job,name,sex,pwd,grade,subject,tel,MESID,PJID,unread);
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
}