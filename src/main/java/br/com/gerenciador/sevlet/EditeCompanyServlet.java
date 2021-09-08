package br.com.gerenciador.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.Company;

//@WebServlet("/editeCompany")
public class EditeCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Long id = Long.parseLong(paramId);
		Bank bank = new Bank();
		Company company = bank.getCompanyId(id);
		
		request.setAttribute("company", company);
		request.getRequestDispatcher("/editeCompany.jsp").forward(request, response);
		
		
	}

}
