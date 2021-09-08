package br.com.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;

public class RemoveCompanyAction implements CompanyAcao{
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String idParam = request.getParameter("id");
		Long id = Long.parseLong(idParam);
		
		Bank bank = new Bank();
		bank.removeCompany(id);
		
		return "redirect:entre?action=ListCompany";
	}

}
