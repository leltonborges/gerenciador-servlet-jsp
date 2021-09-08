package br.com.gerenciador.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.action.CompanyAcao;

//@WebServlet("/entre")
public class UniqueEntre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paraAction = request.getParameter("action");

//		HttpSession session = request.getSession();
//		boolean naoLogado = session.getAttribute("userLogado") ==null;
//		boolean isNotActionProtected = !(paraAction.equals("LoginForm") || paraAction.equals("Login"));
//		
//		if(isNotActionProtected && naoLogado) {
//			response.sendRedirect("entre?action=LoginForm");	
//			return;
//		}

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
//		System.out.println("aqui: "+ nameClass);
//		if (paraAction.equals("ListCompany")) {
//			ListCompanyAction listAction = new ListCompanyAction();
//			resultAction = listAction.execute(request, response);
//		} else if (paraAction.equals("EditeCompany")) {
//			EditeCompanyAction editeAction = new EditeCompanyAction();
//			resultAction = editeAction.execute(request, response);
//		} else if (paraAction.equals("new")) {
//			resultAction = "forward:fromCompany.jsp";
//		} else if (paraAction.equals("RemoveCompany")) {
//			RemoveCompanyAction removeAction = new RemoveCompanyAction();
//			resultAction = removeAction.execute(request, response);
//		} else if (paraAction.equals("NewCompany")) {
//			NewCompanyAction newAction = new NewCompanyAction();
//			resultAction = newAction.execute(request, response);
//		}			

}
