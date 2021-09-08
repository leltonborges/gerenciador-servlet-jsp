package br.com.gerenciador.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;

//@WebServlet("/removeCompany")
public class RemoveCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Long id = Long.parseLong(idParam);
		
		Bank bank = new Bank();
		bank.removeCompany(id);
		
		response.sendRedirect("listCompany");
	}

}
