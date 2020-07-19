package com.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Emp e = EmpDao.getEmployeeById(id);
		out.print("<h1>Update Employee</h1>");
		out.print("<form action='EditServlet2' method='post'>" );
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='pass' value='"+e.getPassword()+"'></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'></td></tr>");
		out.print("<tr><td>Country:</td><td><select name='country'Style='width:150px' value='"+e.getCountry()+
				"'><option>India</option>"+
				  "<option>USA</option>"+
				  "<option>UK</option>"+
				  "<option>France</option>"+
				"</select></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' name='submit' value='Edit and Save'></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
		
	}

}