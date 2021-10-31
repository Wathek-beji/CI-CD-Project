package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entities.Entreprise;
public interface IEntrepriseService {

	List<Entreprise> retrieveAllEntreprise();
	Entreprise addEntreprise(Entreprise en);
	Entreprise updateEntreprise(Entreprise en);
	void deleteEntreprise(String id);
	Entreprise retrieveEntreprise(String id);

}
