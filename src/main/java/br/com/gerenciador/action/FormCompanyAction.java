package br.com.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormCompanyAction implements CompanyAcao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formCompany.jsp";
	}

}
