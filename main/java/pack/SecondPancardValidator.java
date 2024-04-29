package pack;

import jakarta.servlet.Filter;
import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class SecondPancardValidator
 */
@WebFilter("/validate")
public class SecondPancardValidator extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public SecondPancardValidator() {
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
		System.out.println("hiiii");
		//type casting ServletRequest into HttpServletRequest
		HttpServletRequest req=(HttpServletRequest)request;
		//We can read the Requested parameter
		String panNumber=req.getParameter("t1");
		String pan =(String) req.getAttribute("key");
		PrintWriter out=response.getWriter();
		
		if(!pan.startsWith("ABC")) {
			out.println("name should start with either A or B or C");
			//chain.doFilter(request, response);
		}
//		else {
//			PrintWriter out =response.getWriter();
//			out.println("<h3><font color='red'>Not ValidPan Length Excides</font></h3>");
//		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
