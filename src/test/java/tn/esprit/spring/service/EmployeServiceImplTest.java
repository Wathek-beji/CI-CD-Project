package tn.esprit.spring.service;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployeServiceImplTest {

	
	
	
	@Autowired
	IEmployeService es; 

	@Test
	public void testRetrieveAllEmployes() {
		List<Employe> listEmployes = es.retrieveAllEmployes(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(5, listEmployes.size());
	}
	
	
	@Test
	public void testAddEmploye() throws ParseException {
		Employe e = new Employe ("Yosra", "Yosra","yosra@esprit.tn","0000", true, Role.INGENIEUR); 
		Employe employeAdded = es.addEmploye(e); 
		Assert.assertEquals(e.getId(), employeAdded.getId());
	}
 
	@Test
	public void testModifyEmploye() throws ParseException   {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//Date d = dateFormat.parse("2015-03-23");
		Employe e = new Employe (3, "testing", "update","yosra@esprit.tn","0000", true, Role.INGENIEUR);  
		Employe employeUpdated  = es.updateEmploye(e); 
		Assert.assertEquals(e.getId(), employeUpdated.getId());
	}

	@Test
	public void testRetrieveEmploye() {
		Employe employeRetrieved = es.retrieveEmploye("1"); 
		Assert.assertEquals(1L, employeRetrieved.getId());
	}
	
	@Test
	public void testDeleteEmploye() {
		es.deleteEmpoye("46");
		Assert.assertNull(es.retrieveEmploye("46"));
	}
	
	// 5 tests unitaires  

}
