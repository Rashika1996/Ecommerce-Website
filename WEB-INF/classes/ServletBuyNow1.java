import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ServletBuyNow1 extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  { 
    PrintWriter out= res.getWriter();
	res.setContentType("Text/HTML");
	Connection con=null;
	Statement st1=null;
	Statement st2=null;
	ResultSet rs=null;
	ResultSet rs2=null;
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
	String s="<html>"+
"<head>"+
"<title>Welcome</title>"+
"<link type='text/css' rel='stylesheet' href='BuyNow.css'>"+
"<link type='image/png' rel='icon' href='favicon.png'>  <!--<link rel='icon' type='image/png' href=''>-->"+
"</head>"+

"<body>"+
"<header>"+
"<div class='hmid'>"+
"<div class='hl'> E-Store welcomes "+p+" </div>"+
"<div class='hr'>"+ 
"<a href='ServletCart'><img src='images/cart.png' onMouseOver='src='images/cart-hover.png'' onMouseOut='src='images/cart.png'></a>"+
"<a href='ServletPasswordChange'><img src='images/settings.png' onMouseOver='src='images/settings-hover.png'' onMouseOut='src='images/settings.png'></a>"+
"<a href='ServletLogOut'><img src='images/logout.png' onMouseOver='src='images/logout-hover.png'' onMouseOut='src='images/logout.png'></a>"+
"</div>"+
"</div></header> <!-- header section ends here -->";
out.println(s);
try
{
	st1= con.createStatement();
	st2=con.createStatement();
	rs=st1.executeQuery("select * from ItemDetails");
	
	String CodeNum="";
	String Image="",Details="",Price="",Stock="";
	int m=0,kk=0;
	while(rs.next())
	{
		CodeNum=rs.getString(1);
		Image=rs.getString(2);
		Details=rs.getString(3);
		Price=rs.getString(4);
		Stock=rs.getString(5);
rs2=st2.executeQuery("select * from Cart where Email='"+p+"' and Item_Number='"+CodeNum+"'");
	kk=0;
	if(rs2.next())
	{
		kk=1;
	}
		
	if(m%3==0)
		{
	s="<div class='row1'>";
	out.println(s);
		}
	s="<div class='box'>"+
		"<div class='heading'>#"+CodeNum+"</div>"+
		"<div class='pic'><img src='images/"+Image+".png' height='100%'></div>"+
		"<div class='dis'>"+Details+","+Price+","+Stock+"</div>";
		out.println(s);
		if(kk==0)
s="<a href='ServletAdded?mm="+CodeNum+"'><input type='button' value='Add to cart'></a>";
else
s="<a href='ServletAdded?mm="+CodeNum+"'><input type='button' value='Added!'></a>";
	out.println(s);
	s="</div>";
	
	out.println(s);
	m++;
}
s="</div></form>"+
"</body>"+
"</html>";
out.println(s);
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