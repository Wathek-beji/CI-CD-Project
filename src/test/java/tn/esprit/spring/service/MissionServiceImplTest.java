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
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
		
		@Autowired
		IMissionService ms; 
	
		@Test
		public void testRetrieveAllMission() {
			List<Mission> listMission = ms.retrieveAllMission(); 
			// if there are 7 users in DB : 
			Assert.assertEquals(5, listMission.size());
		}
		
		
		@Test
		public void testAddMission() throws ParseException {
			Mission m = new Mission("Wathek", "good"); 
			Mission MissionAdded = ms.addMission(m); 
			Assert.assertEquals(m.getId(), MissionAdded.getId());
		}
	 
		@Test
		public void testModifyMission() throws ParseException   {
			Mission m = new Mission(3, "Wathek2UPDATED", "horribleUPDATED"); 
			Mission MissionUpdated  = ms.updateMission(m); 
			Assert.assertEquals(m.getId(), MissionUpdated.getId());
		}
	
		@Test
		public void testRetrieveMission() {
			Mission MissionRetrieved = ms.retrieveMission(1); 
			Assert.assertEquals(1L, MissionRetrieved.getId());
		}
		
		@Test
		public void testDeleteMission() {
			ms.deleteMission(69);
			Assert.assertNull(ms.retrieveMission(69));
		}
		
		// 5 tests unitaires  
		//JUST ADD 1 TO THE ID YOU WOULD LIKE TO DELETE
}
