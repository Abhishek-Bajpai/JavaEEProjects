package edureka.assignment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.println("Your provided UserID and Password are good to proceed ...!!");

		System.out.println("All seems good, writing info in cookies !! ");
		Cookie uNameCookie = new Cookie("User-Name", request.getParameter("userID"));
		response.addCookie(uNameCookie);

		Cookie uPassCookie = new Cookie("Pass-Code", request.getParameter("passcode"));
		response.addCookie(uPassCookie);

		System.out.println("Forwarding to SUCCESS servlet page !! ");

		RequestDispatcher dispatcher = request.getRequestDispatcher("success");
		dispatcher.forward(request, response);// Forward the control to the next servlet

	}

}
