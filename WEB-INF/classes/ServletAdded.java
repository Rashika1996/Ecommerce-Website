import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletAdded extends HttpServlet
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
	String p=(String)session.getAttribute("Email");
	if(p==null)
		res.sendRedirect("Login.html");
	
	try
	{
	 String CodeNum=req.getParameter("mm");
	 //out.println("hello");
	 //out.println(CodeNum);
	 st=con.createStatement();
	 st1=con.createStatement();
	 
	 rs=st1.executeQuery("select * from ItemDetails where CodeNum='"+CodeNum+"'");
	 String price="";
	 if(rs.next())
	 {
		 price=rs.getString(4);
	 }
	 st.executeUpdate("insert into Cart(Email,Item_Number,Price,Date,Time)values('"+p+"','"+CodeNum+"','"+price+"',CURDATE(),CURTIME())");
con.close();
	res.sendRedirect("ServletBuyNow1");
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