package services;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jayesh.condb.JayShreeRam;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
		try {
		Connection con=(Connection) JayShreeRam.connect();
		Sign sg = new Sign();
		int cust_id = getset.cust_id;
		String name  = request.getParameter("name");
		String gender = request.getParameter("gender");
		int shoenum = Integer.parseInt(request.getParameter("shoesnumber"));
		int age = Integer.parseInt(request.getParameter("age"));
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
			PreparedStatement psmt = con.prepareStatement("insert into register values(?,?,?,?,?,?,?)");
			psmt.setInt(1, cust_id);
			psmt.setString(2, name);
			psmt.setString(3, gender);
			psmt.setInt(4, shoenum);
			psmt.setInt(5, age);
			psmt.setInt(6, height);
			psmt.setInt(7, weight);
			System.out.println(cust_id);
			System.out.println(age);
			int i=psmt.executeUpdate();
			if(i>0)
			{
				System.out.println(" SignUp successfull...");
				response.sendRedirect("login.html");
			}
			else
			{
				System.err.println("Registration Failed..!!");
				response.sendRedirect("register.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
