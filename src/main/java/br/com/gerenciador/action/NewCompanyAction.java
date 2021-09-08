package br.com.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.Company;

public class NewCompanyAction implements CompanyAcao{

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
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
		
		return "redirect:entre?action=ListCompany";
	}
}
