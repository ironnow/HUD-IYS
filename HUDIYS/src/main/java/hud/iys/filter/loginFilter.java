package hud.iys.filter;

import hud.iys.bean.UserBean;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.client.HttpServerErrorException;

public class loginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		UserBean session = (UserBean) req.getSession().getAttribute("userMB");
		String url = req.getRequestURI();
		
		// kullanici login degilse login sayfasina yonlendir
		if( session == null || !session.getIsLogged()) {
			if ( url.indexOf("mevzuatSeti.xhtml") >= 0 || url.indexOf("index.xhtml") >= 0) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/pages/login.xhtml");
			}
			else {
				chain.doFilter(request, response);
			}
		}
		//kullanici login ise 
		else {
			if ( url.indexOf("logout.xhtml") >= 0 ) {
				req.getSession().removeAttribute("userMB");
				resp.sendRedirect(req.getServletContext().getContextPath() + "/pages/login.xhtml");
			}
			else if ( url.indexOf("login.xhtml") >= 0 ) {
				resp.sendRedirect(req.getServletContext().getContextPath() + "/pages/index.xhtml");
			}
			else {
				chain.doFilter(request, response);
			}
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
