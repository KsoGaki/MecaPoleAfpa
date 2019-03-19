package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.mecanique.entity.Formateur;
import fr.afpa.formation.mecanique.repository.FormateurRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = SmallApp.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestFormateurRepository {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	FormateurRepository formateurRepository;

	int listSize;

	/**
	 * INITIALISATION DU SETUP POUR LES TUs
	 */
	@Before
	public void setUp() {
/*
		Formateur formateur1 = new Formateur(null, "jv.gmail.com", "VALJEAN", "Jean", "04 67 14 23 45", "12435687",
				"mot de passe", new Date(), new Date());

		Formateur formateur2 = new Formateur(null, "jd.gmail.com", "DUPOND", "Jacques", "05 72 84 13 21", "68735124",
				"mot de passe2", new Date(), new Date());
		/**
		 * 
		entityManager.persist(formateur1);
		entityManager.persist(formateur2);
		listSize = 2;
	*/}

	/**
	 * TEST UNITAIRE
	 */
	@Test
	public void findAll() {
		List<Formateur> formateurs = (List<Formateur>) formateurRepository.findAll();
		assertEquals(listSize, formateurs.size());
		
	}
}
