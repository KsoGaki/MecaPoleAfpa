package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.mecanique.entity.ControleQualite;
import fr.afpa.formation.mecanique.entity.Eclairage;
import fr.afpa.formation.mecanique.entity.Niveau;
import fr.afpa.formation.mecanique.entity.OrdreReparation;
import fr.afpa.formation.mecanique.entity.Pneumatique;
import fr.afpa.formation.mecanique.entity.Stagiaire;
import fr.afpa.formation.mecanique.entity.StatutOrdreReparation;
import fr.afpa.formation.mecanique.entity.Vehicule;
import fr.afpa.formation.mecanique.entity.Visibilite;
import fr.afpa.formation.mecanique.repository.OrdreReparationRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallAppTest.class)
@DataJpaTest
public class OrdreReparationTests {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private OrdreReparationRepository ordreReparationRepository;
	
	@Before
	public void setUp() {
		
		Eclairage eclairage = new Eclairage(false, false, false, false, false, false, false, false);
		eclairage = testEntityManager.persist(eclairage);
		
		Niveau niveau = new Niveau(false, false, false, false, false);
		niveau = testEntityManager.persist(niveau);
		
		Pneumatique pneumatique = new Pneumatique(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		pneumatique = testEntityManager.persist(pneumatique);
		
		Visibilite visibilite = new Visibilite(false, false, false, false, false, false, false, false, false);
		visibilite = testEntityManager.persist(visibilite);
		
		ControleQualite controleQualite = new ControleQualite(new Date(2019), 10.0, "Observation", pneumatique, eclairage, visibilite, niveau);
		controleQualite = testEntityManager.persist(controleQualite);
		
		StatutOrdreReparation statutOrdreReparation = new StatutOrdreReparation("String");
		statutOrdreReparation = testEntityManager.persist(statutOrdreReparation);
		
		Vehicule vehicule = new Vehicule();
		vehicule = testEntityManager.persist(vehicule);
		
		Stagiaire utilisateur = new Stagiaire();
		utilisateur = testEntityManager.persist(utilisateur);
		
		OrdreReparation ordreReparation = new OrdreReparation("01", new Date(), new Date(), new Date(), "symptomesClient", "interventionARealiser", "interventionRealisee"
				, "futursTravaux", vehicule, statutOrdreReparation, utilisateur);
		ordreReparation = testEntityManager.persist(ordreReparation);

	}	

	@Test
	public void testOrdreReparation() {
		List<OrdreReparation> listOrdreReparation = ordreReparationRepository.findAll();
		assertEquals(1, listOrdreReparation.size());
		
		OrdreReparation ordreReparation = listOrdreReparation.get(0);
		Long idOrdreReparation = ordreReparation.getId();
		
		ordreReparation = ordreReparationRepository.findById(idOrdreReparation).get();
		assertNotNull(ordreReparation);
		
		String symptomesClientBefore = ordreReparation.getSymptomesClient();
		ordreReparation.setSymptomesClient(ordreReparation.getSymptomesClient() + "A");
		ordreReparation = ordreReparationRepository.save(ordreReparation);
		assertNotEquals(symptomesClientBefore, ordreReparationRepository.findById(idOrdreReparation).get().getSymptomesClient());
		
		ordreReparationRepository.deleteById(idOrdreReparation);
		assertFalse(ordreReparationRepository.findById(idOrdreReparation).isPresent());
	}
	

	@After
	public void tearDown() {}

}


