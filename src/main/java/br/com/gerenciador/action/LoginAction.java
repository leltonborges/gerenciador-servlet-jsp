package br.com.gerenciador.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.User;

public class LoginAction implements CompanyAcao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		Bank bank = new Bank();
		User user = bank.existsUser(login, pass);
		
		if(user != null) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("userLogado", user);
			return "redirect:entre?action=ListCompany";
		}else {
			return "redirect:entre?action=LoginForm";						
		}
	}

}
