package br.com.gerenciador.sevlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entre")
public class AutorizationFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServRequest = (HttpServletRequest) request;
		HttpServletResponse httpServResponse = (HttpServletResponse) response;
		System.out.println("AutorizationFilter");
		HttpSession session = httpServRequest.getSession();
		String paraAction = httpServRequest.getParameter("action");

		boolean naoLogado = session.getAttribute("userLogado") ==null;
		boolean isNotActionProtected = !(paraAction.equals("LoginForm") || paraAction.equals("Login"));
		
		if(isNotActionProtected && naoLogado) {
			httpServResponse.sendRedirect("entre?action=LoginForm");	
			return;
		}
		
		chain.doFilter(request, response);
	}

}
