package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.mecanique.entity.Stagiaire;
import fr.afpa.formation.mecanique.repository.StagiaireRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = SmallApp.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestStagiaireRepository {

	@Autowired
	EntityManager entityManager;

	@Autowired
	StagiaireRepository stagiaireRepository;

	int listSize;

	/**
	 * INITIALISATION DU SETUP POUR LES TUs
	 */
	@Before
	public void setUp() {
		
	

		Stagiaire stagiaire1 = new Stagiaire("jv.gmail.com", "VALJEAN", "Jean", "04 68 14 23 45", "12434187",
				"mot de passe", new Date(), new Date(),null, "2 345 678 3",null);
		Stagiaire stagiaire2 = new Stagiaire("jd.gmail.com", "DUPONT", "Jean", "04 67 14 23 45", "12435687",
				"mot de passe2", new Date(), new Date(),null, "2 345 678 4",null);


		entityManager.persist(stagiaire1);
		entityManager.persist(stagiaire2);
		listSize = 2;

	}
	/**
	 * TEST UNITAIRE
	 */
	@Test
	public void findAll() {
		List<Stagiaire> stagiaires = (List<Stagiaire>) stagiaireRepository.findAll();
		assertEquals(listSize, stagiaires.size());
	}
}
