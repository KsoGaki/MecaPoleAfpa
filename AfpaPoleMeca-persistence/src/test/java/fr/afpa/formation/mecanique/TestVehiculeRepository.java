package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;

import java.util.Date;
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

import fr.afpa.formation.mecanique.entity.Vehicule;
import fr.afpa.formation.mecanique.repository.VehiculeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = SmallApp.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestVehiculeRepository {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	VehiculeRepository vehiculeRepository;

	int listSize;
	/**
	 * INITIALISATION DU SETUP POUR LES TUs
	 */
	@Before
	public void setUp() {

		Vehicule vehicule1 = new Vehicule(null, "Dacia", "Sandero", (Double) 15322.0, "954494", "123456789",
				"ZE-763-AX", "1234", new Date(),null);
		Vehicule vehicule2 = new Vehicule(null, "Jeep", "Renegade", (Double) 97654.3, "954494", "123456789",
				"EN-639-SV", "1234", new Date(),null);

		entityManager.persist(vehicule1);
		entityManager.persist(vehicule2);
		listSize = 2;

	}
	/**
	 * TEST UNITAIRE
	 */
	@Test
	public void findAll() {
		List<Vehicule> vehicules = (List<Vehicule>) vehiculeRepository.findAll();
		assertEquals(listSize, vehicules.size());
	}
}
