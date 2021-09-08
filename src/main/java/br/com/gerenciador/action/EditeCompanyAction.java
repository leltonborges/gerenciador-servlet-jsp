package br.com.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.Company;

public class EditeCompanyAction implements CompanyAcao{

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String paramId = request.getParameter("id");
		Long id = Long.parseLong(paramId);
		Bank bank = new Bank();
		Company company = bank.getCompanyId(id);

		request.setAttribute("company", company);
		
		return "forward:editeCompany.jsp";
	}
}
