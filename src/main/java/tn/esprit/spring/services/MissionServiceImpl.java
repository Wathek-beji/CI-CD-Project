package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {

	@Autowired
	MissionRepository MissionRepository;

	private static final Logger l = LogManager.getLogger(MissionServiceImpl.class);

	@Override
	public List<Mission> retrieveAllMission() {
		List<Mission> missions = null; 
		try {
	
			l.info("In retrieveAllMission() : ");
			missions = (List<Mission>) MissionRepository.findAll();  
			for (Mission mission : missions) {
				l.debug("user +++ : " + mission);
			} 
			l.info("Out of retrieveAllMission() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllMission() : " + e);
		}

		return missions;
		
	}

	@Override
	public Mission addMission(Mission m) {
		return MissionRepository.save(m); 
		
	}

	@Override
	public void deleteMission(int id) {
		MissionRepository.deleteById(id);
		
	}

	@Override
	public Mission updateMission(Mission m) {
		return MissionRepository.save(m);
	
	}

	@Override
	public Mission retrieveMission(int id) {
		l.info("in  retrieveMission id = " + id);
		Mission m =  MissionRepository.findById(id).orElse(null);
		//int i = 1/0; 
		//Mission m =  MissionRepository.findById(id).get(); 
		l.info("user returned : " + m);
		return m; 
		
	}
}


