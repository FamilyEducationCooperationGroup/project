package backport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTools {
	private static int M=20;
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
				ans=new Man(m1.username,m1.job,m1.name,m1.sex,m1.pwd,m1.grade,m1.subject,m1.tel,m1.MESID,m1.PJID,m1.unread);
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
		if (m.pwd!=null)
		{
			querrying_order2.append(" pwd='");
			querrying_order2.append(m.pwd+"' AND");
		}
		if (m.grade!=null)
		{
			querrying_order2.append(" grade LIKE '");
			querrying_order2.append(Turn_Grade(m.grade)+"' AND");
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
		list_subject=m.subject.toCharArray();
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
		StringBuffer short_message;
		String temp;
		Man m_sender;
		Man m_addressee;
		Man temp_man;
		int unread;
		temp_man=new Man(sender,2,null,2,null,null,null,null,0,0,0);
		m_sender=Querry(temp_man).get(0);
		temp_man=new Man(addressee,2,null,2,null,null,null,null,0,0,0);
		m_addressee=Querry(temp_man).get(0);
		unread=m_addressee.unread+1;
		
		short_message=new StringBuffer();
		short_message.append(message);
		if (short_message.length()>M)
			temp=short_message.substring(0,M);
		else
			temp=short_message.toString();
		
		adding_order1=new StringBuffer();
		adding_order1.append("insert into mes"+m_sender.MESID);
		adding_order1.append(" values(?,?,?,?,?,?);");

		adding_order2=new StringBuffer();
		adding_order2.append("insert into mes"+m_addressee.MESID);
		adding_order2.append(" values(?,?,?,?,?,?);");	

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
		     Statement1.setString(5,temp);
		     Statement1.setLong(6,2);
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
		     Statement2.setString(5,temp);
		     Statement2.setLong(6,0);
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
                if(Statement1!=null)
                {
                    Statement1.close();
                }
                if(Statement2!=null)
                {
                    Statement2.close();
                }
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
		/*
   	 if(STR.length()<=M)
   	 {
   		 System.arraycopy(STR,0,brief,0,STR.length()); 
   	 }
   	 else
   	 {
   		 System.arraycopy(STR,0,brief,0,M-1);
   	 }
   	 */
	}
	public static void Delete_Message(int MESID,String frm,String date)
	{
		StringBuffer deleting_order;
		deleting_order=new StringBuffer();
		deleting_order.append("delete from mes"+MESID);
		deleting_order.append(" where frm=? and DTA=?;");
		
		System.out.println(deleting_order);

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
		    Statement=connect.prepareStatement(deleting_order.toString());
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
		PreparedStatement Statement1=null,Statement2=null;
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
		     Statement1=connect.prepareStatement(querrying_order.toString());
		     rs =Statement1.executeQuery();
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
			     Statement2=connect.prepareStatement(refesh_order.toString());
			     Statement2.setString(1,person);
			     Statement2.setString(2,date);
			     Statement2.executeUpdate();
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
                if(Statement1!=null)
                {
                    Statement1.close();
                }
                if(Statement2!=null)
                {
                    Statement2.close();
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
	public static void Update_Information(Man update)
	{
		StringBuffer update_order1;
		StringBuffer update_order2;
		StringBuffer update_order3;
		StringBuffer update_order4;
		update_order1=new StringBuffer();
		update_order1.append("update user set grade=? where username=?;");
		update_order2=new StringBuffer();
		update_order2.append("update user set subject=? where username=?;");
		update_order3=new StringBuffer();
		update_order3.append("update user set tel=? where username=?;");
		update_order4=new StringBuffer();
		update_order4.append("update user set pwd=? where username=?;");
		Connection connect=null;
		PreparedStatement Statement1=null,Statement2=null,Statement3=null,Statement4=null;
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
		     Statement1=connect.prepareStatement(update_order1.toString());
		     Statement1.setString(1, update.grade);
		     Statement1.setString(2, update.username);
		     Statement1.executeUpdate();
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
		     Statement2=connect.prepareStatement(update_order2.toString());
		     Statement2.setString(1, update.subject);
		     Statement2.setString(2, update.username);
		     Statement2.executeUpdate();
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
		    	 Statement3=connect.prepareStatement(update_order3.toString());
		    	 Statement3.setString(1, update.tel);
			     Statement3.setString(2, update.username);
			     Statement3.executeUpdate();
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
		    	 Statement4=connect.prepareStatement(update_order4.toString());
		    	 Statement4.setString(1, update.pwd);
			     Statement4.setString(2, update.username);
			     Statement4.executeUpdate();
		     }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
	    }
		finally
        {
            try {
                if(Statement1!=null)
                {
                    Statement1.close();
                }
                if(Statement2!=null)
                {
                    Statement2.close();
                }
                if(Statement3!=null)
                {
                    Statement3.close();
                }
                if(Statement4!=null)
                {
                    Statement4.close();
                }
                if(connect!=null)
                {
                    connect.close();
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
	}
	public static void Rsfresh_unread(String originuser,int i) {
		int num=0;
		Man man=new Man(originuser,2,null,2,null,null,null,null,0,0,0);
		for(Man m: Querry(man)) {
			num=m.unread+i;
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
		     Statement=connect.prepareStatement("update user set unread= ? where username=?");
		     Statement.setLong(1, num);
		     Statement.setString(2, originuser);
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
	public static void Add_pj(pj p1,String tag) {
		Connection connect=null;
		PreparedStatement Statement=null;
		Man tempman=new Man(tag,2,null,2,null,null,null,null,0,0,0);
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
	public static void SetPjInt(String username,String frm,String DTA,int pos,int dat) {
		String ope;
		Connection connect=null;
		PreparedStatement Statement=null;
		Man tempman=new Man(username,2,null,2,null,null,null,null,0,0,0);
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
	public static boolean CheckPjByusername(String frm, String to) {
		int flag=0;
		Connection connect=null;
		PreparedStatement Statement=null;
		ResultSet rs=null;
		Man tempman=new Man(frm,2,null,2,null,null,null,null,0,0,0);
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
		if(flag==1)
		{
			return true;
		}
		return false;
	}
	
}