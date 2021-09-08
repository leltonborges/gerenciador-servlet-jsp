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

import br.com.gerenciador.action.CompanyAcao;

//@WebFilter("/entre")
public class ControllerFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ControllerFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paraAction = request.getParameter("action");
		
		String nameClass = "br.com.gerenciador.action." + paraAction + "Action";
		String resultAction = null;

		CompanyAcao companyAcao;
		try {
			@SuppressWarnings("rawtypes")
			Class typeClass = Class.forName(nameClass);
			companyAcao = (CompanyAcao) typeClass.newInstance();
			resultAction = companyAcao.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		if (splitString(resultAction)[0].equals("forward")) {
			request.getRequestDispatcher("WEB-INF/view/" + splitString(resultAction)[1]).forward(request, response);
		} else {
			response.sendRedirect(splitString(resultAction)[1]);
		}

	}

	private String[] splitString(String text) {
		return text.split(":");
	}

}
