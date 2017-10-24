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
		     Statement=connect.prepareStatement("create table " + mES +" (pos int,frm varchar(20),DTA varchar(20),STR varchar(1000),readed int)");
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
	public static List<mes> QuerryMes(int ps,int rd,int MSID){
		List<mes> ans=new ArrayList<mes>();
		int pos;
		String person;
		String DTA;
		String STR;
		int readed;
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
		     Statement=connect.prepareStatement("SELECT * FROM" + " 'mes"+String.valueOf(MSID)+"'"+" where "+temp+" ORDER BY readed ASC");
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
		StringBuffer querying_order1;
		StringBuffer querying_order2;
		querying_order1=new StringBuffer();
		querying_order1.append("SELECT * from user where");
//-------------------------------------------------------		
		querying_order2=new StringBuffer();
		if (m.username!=null)
		{
			querying_order2.append(" username='");
			querying_order2.append(m.username+"' AND");
		}
		if (m.job!=2)	
		{
			querying_order2.append(" job='");
			querying_order2.append(String.valueOf(m.job)+"' AND");
		}
		if (m.name!=null)
		{
			querying_order2.append(" name='");
			querying_order2.append(m.name+"' AND");
		}
		if (m.sex!=2)	
		{
			querying_order2.append(" sex='");
			querying_order2.append(String.valueOf(m.sex)+"' AND");
		}
		if (m.pwd!=null)
		{
			querying_order2.append(" pwd='");
			querying_order2.append(m.pwd+"' AND");
		}
		if (m.grade!=null)
		{
			querying_order2.append(" grade LIKE '");
			querying_order2.append(Turn_Grade(m.grade)+"' AND");
		}
		if (m.subject!=null)
		{
			querying_order2.append(" subject LIKE '");
			querying_order2.append(Turn_Subject(m.subject)+"' AND");
		}
		querying_order1.append(querying_order2.substring(0, querying_order2.length()-4)+";");
		System.out.println(querying_order1);
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
		     Statement=connect.prepareStatement(querying_order1.toString());
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
		StringBuffer matching_order1;
		StringBuffer matching_order2;
		StringBuffer matching_order3;
		matching_order1=new StringBuffer();
		matching_order1.append("SELECT DISTINCT * from user where");
//-------------------------------------------------------		
		matching_order2=new StringBuffer();
		matching_order3=new StringBuffer();
		matching_order3.append(") AND (");
		char []list_grade;
		char []list_subject;
		char []temp;
		list_grade=m.grade.toCharArray();
		list_subject=m.grade.toCharArray();
		if (m.job==0)
			matching_order2.append(" job=1 AND (");
		else
			matching_order2.append(" job=0 AND (");
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
		matching_order1.append(matching_order3.substring(0, matching_order3.length()-3)+");");
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
	public static void Add_Message(String sender,String addressee,String date,String message)
	{
		StringBuffer adding_order1;
		StringBuffer adding_order2;
		Man m_sender;
		Man m_addressee;
		Man temp_man;
		int unread;
		temp_man=new Man(sender,2,null,2,null,null,null,null,0,0,0);
		m_sender=Querry(temp_man).get(0);
		temp_man=new Man(addressee,2,null,2,null,null,null,null,0,0,0);
		m_addressee=Querry(temp_man).get(0);
		unread=m_addressee.unread+1;
		adding_order1=new StringBuffer();
		adding_order1.append("insert into mes"+m_sender.MESID);
		adding_order1.append(" values(?,?,?,?,?);");

		adding_order2=new StringBuffer();
		adding_order2.append("insert into mes"+m_addressee.MESID);
		adding_order2.append(" values(?,?,?,?,?);");	

		System.out.println(adding_order1);
		System.out.println(adding_order2);

		Connection connect=null;
		PreparedStatement Statement1=null,Statement2=null,Statement3=null;
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
		     Statement1=connect.prepareStatement(adding_order1.toString());
		     Statement1.setLong(1,0);
		     Statement1.setString(2,addressee);
		     Statement1.setString(3,date);
		     Statement1.setString(4,message);
		     Statement1.setLong(5,2);
		     Statement1.executeUpdate();
		     
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement2=connect.prepareStatement(adding_order2.toString());
		     Statement2.setLong(1,1);
		     Statement2.setString(2,sender);
		     Statement2.setString(3,date);
		     Statement2.setString(4,message);
		     Statement2.setLong(5,0);
		     Statement2.executeUpdate();
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		try
		{
		     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=true","root","1234");
		     Statement3=connect.prepareStatement("update user set unread=? where username=?;");
		     Statement3.setLong(1,unread);
		     Statement3.setString(2,addressee);
		     Statement3.executeUpdate();
		     
		}
		catch (SQLException e)
		{
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if(Statement3!=null)
                {
                    Statement3.close();
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
	}
	public static void Delete_Message(mes message,Man m)
	{
		StringBuffer deleting_order;
		
		deleting_order=new StringBuffer();
		deleting_order.append("delete from msg"+m.MESID);
		deleting_order.append(" where pos="+message.pos);
		deleting_order.append(" and person='"+message.person);
		deleting_order.append("' and DTA='"+message.DTA);
		deleting_order.append("' and STR='"+message.STR);
		deleting_order.append("';");
		
		System.out.println(deleting_order);

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
		     Statement=connect.prepareStatement(deleting_order.toString());
		     rs =Statement.executeQuery();
		     
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
	}
}