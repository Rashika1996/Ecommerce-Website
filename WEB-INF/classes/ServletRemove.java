import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletRemove extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	HttpSession session=req.getSession();
	String p=(String)session.getAttribute("Email");
	if(p==null)
		res.sendRedirect("Login.html");
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
		String SNo=req.getParameter("rm");
		out.println(SNo);
		int SrNo=Integer.parseInt(SNo);
		 st=con.createStatement();
	 st.executeUpdate("delete from Cart where SrNo="+SrNo);
	 con.close();
	 res.sendRedirect("ServletCart");
	 
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