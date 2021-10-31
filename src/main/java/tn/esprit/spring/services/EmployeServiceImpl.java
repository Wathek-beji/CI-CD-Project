package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes = null; 
		
		try {
	
			l.info("In retrieveAllEmployes() : ");
			employes= (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employes) {
				l.debug("employe +++ : " + employe);
			} 
			l.info("Out of retrieveAllEmployes() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmployes() : " + e);
		}

		return employes;
	}
		

	@Override
	public Employe addEmploye(Employe e) {
		return employeRepository.save(e);
	}

	@Override
	public void deleteEmpoye(String id) {
		employeRepository.deleteById(Integer.parseInt(id));
		
	}

	@Override
	public Employe updateEmploye(Employe e) {
		return employeRepository.save(e);
	}

	@Override
	public Employe retrieveEmploye(String id) {
		l.info("in  retrieveEmploye id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Employe e =  employeRepository.findById(Integer.parseInt(id)).orElse(null); 
		l.info("employe returned : " + e);
		return e; 
		
	}
}


	
	
	