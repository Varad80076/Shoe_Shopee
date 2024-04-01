package services;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayesh.condb.JayShreeRam;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try{
			
			Connection con=(Connection) JayShreeRam.connect();
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			java.sql.PreparedStatement ps1=con.prepareStatement("select * from  sign where email=? and pass=? ");
			ps1.setString(1,email);
			ps1.setString(2,pass);
			ResultSet rs = ps1.executeQuery();
			if(rs.next())
			{
				System.out.println("Login Successfull...");
				response.sendRedirect("shop.html");
			}
			else
			{
				System.err.println("Login Failed..!!");
				response.sendRedirect("login.html");
			}
			
		}
		catch(Exception  e)
		{
			
		}
	}

}
