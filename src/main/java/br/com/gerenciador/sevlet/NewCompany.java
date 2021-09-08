package br.com.gerenciador.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.Company;

//@WebServlet(urlPatterns = {"/newCompany"})
public class NewCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Company c = new Company();
		String paramId = request.getParameter("id");
		String name = request.getParameter("name");
		String data = request.getParameter("data");
		Long id = null;
		
		if(paramId != null) {
			id = Long.parseLong(paramId);
			if(id != null) {
				c.setId(id);
			}
		}
		
		c.setName(name);
		
		c.setDataOpen(data);

		Bank bank = new Bank();
		bank.addCompany(c);

		request.setAttribute("company", c.getName());
		response.sendRedirect("listCompany");


	}

}
