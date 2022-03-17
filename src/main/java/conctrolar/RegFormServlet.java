package conctrolar;
import java.lang.*;
import java.sql.*;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class RegFormServlet
 */
@WebServlet("/RegFormServlet")
public class RegFormServlet extends GenericServlet {
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		int id=0;
		String name ="" , email ="", adderess ="";
		try {
		id=Integer.parseInt(req.getParameter("id"));
		 name=req.getParameter("name");
		 email=req.getParameter("email");
		 adderess=req.getParameter("adderess");
		}catch(Exception e)
		{
              out.println("<font color='black'><h1>please enter valid data</h1></font>");
			
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhupal","root","admin");
			PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, email);
			pst.setString(4, adderess); 
			int i=pst.executeUpdate();
			
			if(i!=0)
			{
				out.println("<font color='green'><h1>SUCESS</h1></font>");
			}
			else
			{
				out.println("<font color='red'><h1>FAIL</h1></font>");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			out.println("<font color='red'><h1>"+e.getMessage()+"</h1></font>");
		}
		
				
	}

}
