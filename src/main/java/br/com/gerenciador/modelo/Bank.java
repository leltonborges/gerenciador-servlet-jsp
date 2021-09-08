package br.com.gerenciador.modelo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Bank {

	private static Set<Company> listCompany = new HashSet<>();
	private static Set<User> listUser = new HashSet<>();
	private static Long keyid = 1L;
	
	static {
		Company c1 = new Company();
		c1.setId(keyid++);
		c1.setName("Google");;
		c1.setDataOpen("12/01/2022");
		Company c2 = new Company();
		c2.setId(keyid++);
		c2.setName("Facebook");
		c2.setDataOpen("12/01/2022");
		Bank.listCompany.add(c1);
		Bank.listCompany.add(c2);
		
		User u1 = new User();
		u1.setLogin("leo");
		u1.setPass("123");
		User u2 = new User();
		u2.setLogin("ana");
		u2.setLogin("321");
		
		listUser.add(u1);
		listUser.add(u2);
		
	}
	
	public void addCompany(Company company) {
		if(company.getId() != null) {
			
			Company existsCompany = listCompany.stream()
					.filter(c -> c.getId().equals(company.getId()))
					.findFirst().get();		
			
			existsCompany.setName(company.getName());
			existsCompany.setDataOpen(company.getDataOpen());
			listCompany.add(existsCompany);
		}else {
			company.setId(Bank.keyid++);
			listCompany.add(company);			
		}
	}

	public Set<Company> getCompanies(){
		return Bank.listCompany;
	}
	
	public void removeCompany(Long id) {
		getCompany(id).ifPresent(c -> listCompany.remove(c));
	}
	
	private Optional<Company> getCompany(Long id) {
		return Bank.listCompany
				.parallelStream()
				.filter(c -> c.getId().equals(id))
				.findFirst();
	}
	
	public Company getCompanyId(Long id) {
		return getCompany(id).get();
	}
	
	public User existsUser(String login, String pass) {
		User user = listUser.parallelStream()
				.filter(u -> u.isEqual(login, pass))
				.findFirst()
				.orElse(null);
					
		return user;
	}
}
