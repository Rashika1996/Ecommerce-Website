import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletPasswordUpdated extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st1=null;
	Statement st=null;
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
	String oldpass= req.getParameter("s1");
	String newpass= req.getParameter("s2");
	//String retypepass= req.getParameter("s3");
	st=con.createStatement();
	st1= con.createStatement();
	rs=st.executeQuery("select * from SignUp where Email='"+p+"'");
	String password="";
	if(rs.next())
	{
		password=rs.getString(3);
		
	}
	if(oldpass.equals(password))
	{
		    st1.executeUpdate("update SignUp set password='"+newpass+"' where Email='"+p+"'");
			res.sendRedirect("ServletPasswordChange?k=1");
		}
		else
		{
			res.sendRedirect("ServletPasswordChange?k=2");
		}
		  
	con.close();
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