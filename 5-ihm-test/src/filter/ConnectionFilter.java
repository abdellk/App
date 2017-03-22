package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import composants.AccueilGUI;

public class ConnectionFilter implements Filter {
	

	public ConnectionFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	/*
	 * FILTRE DE ITCUTIES
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the loginBean from session attribute
        AccueilGUI accueil = (AccueilGUI)((HttpServletRequest)request).getSession().getAttribute("email");
         
        // For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        if (accueil == null || !accueil.isConnecter()) {
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/authentification.xhtml");
        }
        else chain.doFilter(request, response);
             
    }
	
	@Override
	public void destroy() {

	}
	
	/*
	 *FILTRE DU KUMAR
	 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			if (reqURI.indexOf("/authentification.xhtml") >= 0
					|| (ses != null && ses.getAttribute("email") != null)
					|| reqURI.indexOf("/public/") >= 0
					|| reqURI.contains("javax.faces.resource"))
				chain.doFilter(request, response);
			else
				resp.sendRedirect(reqt.getContextPath() + "/faces/authentification.xhtml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	 */
	
}
