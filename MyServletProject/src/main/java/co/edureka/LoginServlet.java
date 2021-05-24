package co.edureka;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
// Replacing XML way; base url + /login url pattern mapped to this LoginServlet.
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uName = request.getParameter("userName");
		if(uName.equals("admin")) {
			//response.sendRedirect("http://www.edureka.co");// The control now returns to the client & URL is fired from the client as a new request.
			
			//1- Session Management/tracking : Cookie impl  
			Cookie cookie1 = new Cookie("username", uName);
			cookie1.setSecure(true);
//			cookie1.setHttpOnly(true);
//			cookie1.setMaxAge(600);
			
			Cookie cookie2=new Cookie("password", request.getParameter("pwd"));
			cookie1.setSecure(true);
			cookie1.setHttpOnly(true);
			cookie1.setMaxAge(600);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);

			
			// 2. URL Rewriting for Session Management
//			out.print("<a href='welcome?uname="+uName+"'>HomeMe</a><br/>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome");
			dispatcher.forward(request, response);// Forward the control to the next servlet
			
			
			//3. Hidden input parameters for Session Management
			//Retrieving hidden values
			String hiddenValueString = request.getParameter("company");
			if("edureka".equals(hiddenValueString)){
				out.println("Edureka is the right choice for learners !! ");
			}
				
			//4 HttpSession for Session Management
			HttpSession httpSession = request.getSession();
			System.out.println(httpSession.getId());
			out.println("Session ID: " + httpSession.getId());
			httpSession.setAttribute("SecretInfo", hiddenValueString);
			
			out.println(httpSession.getAttribute("SecretInfo"));
			out.println(httpSession.getCreationTime());
			out.println(httpSession.getLastAccessedTime());
			httpSession.invalidate();
			
			
		} else {
			out.print("You're not an authorized user !");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);// Include the resource in the current servlet which is login.html 
		}
		out.close();
	}

}
