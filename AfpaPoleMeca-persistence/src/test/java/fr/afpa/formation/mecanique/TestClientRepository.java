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

import fr.afpa.formation.mecanique.entity.Client;
import fr.afpa.formation.mecanique.repository.ClientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = SmallApp.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class TestClientRepository {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ClientRepository clientRepository;

	int listSize;

	/**
	 * INITIALISATION DU SETUP POUR LES TUs
	 */
	@Before
	public void setUp() {

		Client client1 = new Client(null, "jv.gmail.com", "VALJEAN", "Jean", "0213243546", "451267", "2 345 678 3",
				new Date(), "N", null);
		Client client2 = new Client(null, "jd.gmail.com", "DUPOND", "Jacques", "1314151617", "368992", "1 234 526 2",
				new Date(), "O",null);

		entityManager.persist(client1);
		entityManager.persist(client2);
		listSize = 2;

	}

	/**
	 * TEST UNITAIRE
	 */
	@Test
	public void findAll() {
		List<Client> clients = (List<Client>) clientRepository.findAll();
		assertEquals(listSize, clients.size());
	}
}
