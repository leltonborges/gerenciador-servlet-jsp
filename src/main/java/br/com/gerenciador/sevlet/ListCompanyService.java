package br.com.gerenciador.sevlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.gerenciador.modelo.Bank;
import br.com.gerenciador.modelo.Company;

@WebServlet(urlPatterns = "/companies")
public class ListCompanyService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getHeader("Accept");
		Set<Company> companies = new Bank().getCompanies();

		if (value.endsWith("xml")) {
			XStream xml = new XStream();
			response.setContentType("application/xml");
			response.getWriter().print(xml.toXML(companies));
		} else if (value.endsWith("json")) {
			Gson gson = new Gson();
			response.setContentType("application/json");
			response.getWriter().print(gson.toJson(companies));
		}else {
			response.setContentType("application/json");
			response.getWriter().print("{'message: 'no content''}");			
		}

	}

}
