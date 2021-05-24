package edureka.assignment.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login")
public class LoginFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public LoginFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html");
		boolean userNameValid=false, passwordValid=false;
//UserName field Validation		
		if (request.getParameter("userID").contains("@") && request.getParameter("userID").endsWith(".com")) {
			userNameValid=true;
//			chain.doFilter(request, response);
		} else {
			response.getWriter().println("<label style= \'color:red\'><h3>" + request.getParameter("userID")
					+ " is not a valid user name</h3></label>");
			response.getWriter().println(
					"<label style= \"color:red\">User Name must be a valid email address (Eg: test@edureka.com) </label>");
			response.getWriter().println(
					"<br/><label style= \"color:red\">Pls note that only ''dot com'' emails are permittable at this time</label><br/>");
		}

//passcode field validation		
		
		if ((request.getParameter("passcode").contains("!") || request.getParameter("passcode").contains("#")
				|| request.getParameter("passcode").contains("$") || request.getParameter("passcode").contains("*"))
				&& request.getParameter("passcode").length() >= 8) {
			passwordValid=true;
//			chain.doFilter(request, response);
		} else {
			System.out.println("Invalid Password - " + request.getParameter("passcode"));
			response.getWriter().println(
					"<label style= \'color:red\'><h3>Password is invalid.</h3></label><br/><label style= \'color:red\'>Password must be atleast 8 characters long and must contain atleast one of these allowed special characters~ ! # $ * </label><br/></label>");
		}
		

		if(userNameValid && passwordValid) {
			System.out.println("Credentials are GOOD ");
			chain.doFilter(request, response);

			//(HttpServletRequest)request.setAttribute("Credentials", "GOOD");
		}else {
			System.out.println("Credentials are BAD ..Staying on login screen ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);						
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
