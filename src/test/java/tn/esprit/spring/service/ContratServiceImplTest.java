package tn.esprit.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IContratService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {

    @Autowired
    IContratService cs;

    @Test
    public void testRetrieveAllContrats() {
        List<Contrat> listContrats = cs.retrieveAllContrats();
        // if there are 7 contrats in DB :
        Assert.assertEquals(4, listContrats.size());
    }

    @Test
    public void testAddContrat() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = dateFormat.parse("2015-03-23");
        Contrat c = new Contrat(d, "CDI", 3000);
        Contrat contratAdded = cs.addContrat(c);
        Assert.assertEquals(c.getReference(), contratAdded.getReference());
    }

    @Test
    public void testModifyContrat() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = dateFormat.parse("2016-03-23");
        Contrat c = new Contrat(3, d, "CDDtestUpdate", 3500);
        Contrat contratAdded = cs.updateContrat(c);
        Assert.assertEquals(c.getReference(), contratAdded.getReference());
    }

    @Test
    public void testRetrieveContrat() {
        Contrat contratRetrieved = cs.retrieveContrat("1");
        Assert.assertEquals(1L, contratRetrieved.getReference());
    }
    @Test
    public void testDeleteContrat() {
        cs.deleteContrat("53");
        Assert.assertNull(cs.retrieveContrat("53"));
    }
    




}
