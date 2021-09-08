package br.com.gerenciador.sevlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.Company;

//@WebServlet("/listCompany")
public class ListCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bank bank = new Bank();
		Set<Company> listCompany = bank.getCompanies();
		
		request.setAttribute("listCompany", listCompany);
		request.getRequestDispatcher("/listCompany.jsp")
			.forward(request, response);
		
	}

}
