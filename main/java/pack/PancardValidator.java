package pack;

import jakarta.servlet.Filter;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class PancardValidator
 */
@WebFilter("/validate")
public class PancardValidator extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public PancardValidator() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		response.setContentType("text/html");
		//type casting ServletRequest into HttpServletRequest
		HttpServletRequest req=(HttpServletRequest)request;
		//We can read the Requested parameter
		String panNumber=req.getParameter("t1");
		String regEx="[A-Z]{5}[1-9]{4}[A-z]{1}";
		if(panNumber.matches(regEx)) {
//			ServletContext context=getServletContext();
//			context.setAttribute("pankey", panNumber);
			req.setAttribute("key", panNumber);
			chain.doFilter(request, response);
			
			
			
		}
		else {
			PrintWriter out =response.getWriter();
			out.println("<h3><font color='red'>Not ValidPan </font></h3>");
			out.println("<script>alert('not valid')</script>");
		}
		//System.out.println("hi i am filter");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
