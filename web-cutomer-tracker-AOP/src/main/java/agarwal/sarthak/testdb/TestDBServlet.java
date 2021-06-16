package agarwal.sarthak.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		// get connection to database
		try
		{
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: "+ jdbcURL);
			Class.forName(driver);
			Connection mycon = DriverManager.getConnection(jdbcURL, user, pass);
			out.println("Connection successful");
			mycon.close();
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
			throw new ServletException(exe);
		}
	}

}
