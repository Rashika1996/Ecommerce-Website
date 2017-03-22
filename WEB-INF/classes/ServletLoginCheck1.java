import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletBuyNow extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st1=null;
	ResultSet rs=null;
	HttpSession session=req.getSession();
	String p=(String)session.getAttribute("Email");
    	
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
	  String Email= req.getParameter("p1");
	  String Password= req.getParameter("p2");
	  st1= con.createStatement();
	  
	  rs=st1.executeQuery("select * from SignUp where Email='"+Email+"' and Password='"+Password+"'");
	 if(rs.next())
	 {
		 session.setAttribute("Email",Email);
		 con.close();
	 out.println("Welcome to this Website!!!");
	 }
	 else
	 {
		 con.close();
	 res.sendRedirect("invalid.html");
	 }
	   
	}
	 catch(SQLException e3)
	{
	  out.println(e3);
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