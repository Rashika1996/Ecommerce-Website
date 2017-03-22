//Connectivity of database with Desktop Application method-->
import java.awt.*;
import javax.swing.*;
import java.sql.*;
/*<applet code="SwingDatabase" width=1000 height=1000>
</applet>*/

pubic class SwingDatabase extends JApplet
{
	
   Connection con=null;
   Statement st=null;
   ResultSet rs=null;
 public void init()
 {
   
   try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");/* Loading Driver using this static class named Class*/
	  con=DriverManager.getConnection("jdbc:odbc:SW");
	}
    catch(ClassNotFoundException e1)
	{
	  out.println(e1);
	}
    catch(SQLException e2)
	{
	  out.println(e2);
	}
	
 }
 
 public void paint(Graphics g)
 {
 try
	{
		st=con.createStatment();
		rs=st.executeQuery("select * from Student");
		String Name="",Roll="",Dept="";
		int y=50;
		while(rs.next())
		{
			Name=rs.getString(1);
			Roll=rs.getString(2);
			Dept=res.getString(3);
			g.drawString(Name,50,y);
			g.drawString(Roll,100,y);
			g.drawString(Dept,150,y);
			y=y+30;
			
		}
		con.close();
		
	}
	catch(SQLException e3)
	{
	  
	}
	catch(Exception e4)
	{
	  
	}
	

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
   {
     doGet(req,res);
   }
  }
}