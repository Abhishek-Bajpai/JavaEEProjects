package co.edureka;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet Filter implementation class PasswordFilter
 */
//must match login servlet url-pattern to do preprosessing on pwd
@WebFilter("/login") 
public class PasswordFilter extends HttpFilter implements Filter{

    /**
     * Default constructor. 
     */
	public PasswordFilter() {
		super();
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String passwordString = request.getParameter("pwd");
		if(passwordString.length() >= 8 ) {
			chain.doFilter(request, response);
		}else {
		out.println("<label style= \"color:red\">Password must be minimum of 8 characters</label>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
		dispatcher.include(request, response);// Include the resource in the current servlet which is login.html 

		}
		
		// pass the request along the filter chain
//		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
