package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayesh.condb.JayShreeRam;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Mail
 */
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mail() {
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
			java.sql.PreparedStatement ps1=con.prepareStatement("insert into mail values(?)");
			ps1.setString(1,email);
			int i=ps1.executeUpdate();
			if(i==1)
			{
				System.out.println(" Address upload Successfully...");
				response.sendRedirect("payment.html");
			}
			else
			{
				System.err.println("Registration Failed..!!");
			}
			response.sendRedirect("checkout.html");
			
			
			
		}
		catch(Exception  e)
		{
			e.printStackTrace();
			
		}
	}

}
