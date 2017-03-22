import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletSignUp extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st1=null,st2=null;
	ResultSet rs=null;
	try
	{
	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");/* Loading Driver using this static class named Class*/
	  con=DriverManager.getConnection("jdbc:odbc:ECOM");
	}
    catch(ClassNotFoundException e1)
	{
	  out.println(e1);
	}
    catch(SQLException e2)
	{
	  out.println(e2);
	}
	try
	{
	  String Name= req.getParameter("t1");
	  String Email= req.getParameter("t2");
	  String Password= req.getParameter("t3");
	  String Contact= req.getParameter("t4");
	  String City= req.getParameter("t5");
	  String Address= req.getParameter("t6");
	  st1= con.createStatement();
	   st2= con.createStatement();
	  
	  st1.executeUpdate("insert into SignUp values('"+Name+"','"+Email+"','"+Password+"','"+Contact+"','"+City+"','"+Address+"')");
	  st2.executeUpdate("insert into Login values('"+Email+"','"+Password+"')");
	 out.println("Registration successful");
	 out.println("<a href='Index.html'>home</a><br><a href='Login.html'>login</a>");
	   con.close();
	}
	 catch(SQLException e3)
	{
	  res.sendRedirect("ServletEntries?k=1");
	}
	catch(Exception e4)
	{
	  out.println(e4);
	}
	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
 doGet(req,res);
}
  
 }