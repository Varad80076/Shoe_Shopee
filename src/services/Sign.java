package services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayesh.condb.JayShreeRam;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Sign
 */
public class Sign extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sign() {
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
			int cust_id = getset.getCust_id();
			String email=request.getParameter("email");
			String pass=request.getParameter("pass");
			String cpass=request.getParameter("cpass");
			if(pass.equals(cpass)){
			java.sql.PreparedStatement ps1=con.prepareStatement("insert into sign values(?,?,?,?)");
			ps1.setInt(1, cust_id);
			ps1.setString(2,email);
			ps1.setString(3,pass);
			ps1.setString(4, cpass);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				System.out.println(" SignUp successfull...");
				response.sendRedirect("register.html");
			}
			else
			{
				System.err.println("Registration Failed..!!");
				response.sendRedirect("login.html");
			}
			}
			else{
				response.sendRedirect("login.html");
			}
			
		}
		catch(Exception  e)
		{
			 
		}
	}

}
