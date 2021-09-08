package br.com.gerenciador.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.Company;

public class ListCompanyAction implements CompanyAcao{

	
	public String execute(HttpServletRequest request, HttpServletResponse response){
		
		Bank bank = new Bank();
		Set<Company> listCompany = bank.getCompanies();
		request.setAttribute("listCompany", listCompany);
		return "forward:listCompany.jsp";
	}
}
