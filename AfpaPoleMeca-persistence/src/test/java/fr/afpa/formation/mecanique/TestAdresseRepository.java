package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;

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

import fr.afpa.formation.mecanique.entity.Adresse;
import fr.afpa.formation.mecanique.repository.AdresseRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = SmallApp.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestAdresseRepository {

	@Autowired
	EntityManager entityManager;

	@Autowired
	AdresseRepository adresseRepository;

	int listSize;

	/**
	 * INITIALISATION DU SETUP POUR LES TUs
	 */
	@Before
	public void setUp() {

		Adresse adresse1 = new Adresse(null, "4 place de l'église", "par ici", "34000", "Montpellier");
		Adresse adresse2 = new Adresse(null, "3 impasse des Coquelicots", "par là", "31000", "Toulouse");
		entityManager.persist(adresse1);
		entityManager.persist(adresse2);
		listSize = 2;
	}

	/**
	 * TEST UNITAIRE
	 */
	@Test
	public void findAll() {
		List<Adresse> adresses = (List<Adresse>) adresseRepository.findAll();
		assertEquals(listSize, adresses.size());
	}
}
