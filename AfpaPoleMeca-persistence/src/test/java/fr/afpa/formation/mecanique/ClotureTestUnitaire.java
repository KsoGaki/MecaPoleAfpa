package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afpa.formation.mecanique.entity.Cloture;
import fr.afpa.formation.mecanique.entity.Fournisseur;
import fr.afpa.formation.mecanique.entity.StatutCloture;
import fr.afpa.formation.mecanique.repository.ClotureRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallApp.class)
@DataJpaTest
public class ClotureTestUnitaire {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ClotureRepository clotureRepo;
	
	@Autowired
	private StatutClotureRepository statutRepo;
	
	@Before
	public void setUp() {
		String libelle1 = "test1";
		String libelle2 = "test1";
		
		Date date1 = new Date();
		Date date2 = new Date();
		
		StatutCloture statut1 = new StatutCloture(libelle1);
		StatutCloture statut2 = new StatutCloture(libelle2);
		entityManager.persist(statut1);
		entityManager.persist(statut2);
		
		Cloture cloture1 = new Cloture(date1,statut1);
		Cloture cloture2 = new Cloture(date2,statut2);
		entityManager.persist(cloture1);
		entityManager.persist(cloture2);
	}
	@Test
	public void findAll() {
		List<StatutCloture> listStatut = (List<StatutCloture>) statutRepo.findAll();
		assertNotNull(listStatut);
		assertEquals(2,listStatut.size());
	}
	
	
	
	@Test
	public void testCloture() {
		String libTest = "test1";		
		
		Date dateTest = new Date();		
		////////SAVE\\\\\\\\\\
		StatutCloture statut = new StatutCloture(libTest);		
		statutRepo.save(statut);
		assertNotNull(statut);

		
		Cloture cloture = new Cloture(dateTest,statut);		
		clotureRepo.save(cloture);
		Long id = cloture.getId();
		assertNotNull(cloture);
		///////////FIND BY ID\\\\\\\\\\\\\\
		Cloture getId = clotureRepo.findById(id).get();
		
		assertEquals(libTest, getId.getStatutCloture().getLibelle());
		assertEquals(dateTest, getId.getDate());		
		assertEquals(libTest, cloture.getStatutCloture().getLibelle());
		assertEquals(dateTest, cloture.getDate());
		
		
		///////////////////DELETE\\\\\\\\\\\\\\\\\\
		List<Cloture> listStatut = (List<Cloture>) clotureRepo.findAll();
		assertNotNull(listStatut);
		assertEquals(3,listStatut.size());
		
		clotureRepo.deleteById(id);
		
		listStatut = (List<Cloture>) clotureRepo.findAll();
		assertNotNull(listStatut);
		assertEquals(2,listStatut.size());
		
		/////////////UPDATE\\\\\\\\\\\\\
		
		
		
		
		StatutCloture statut1 = new StatutCloture(libTest);		
		statutRepo.save(statut1);
		assertNotNull(statut1);

		Date avant = new Date();
		Cloture cloture1 = new Cloture(avant,statut1);		
		clotureRepo.save(cloture1);
		Long id1 = cloture1.getId();
		Cloture clotureid = clotureRepo.findById(id1).get();
		cloture1.setDate(new Date());
		cloture1 = clotureRepo.save(cloture1);
		assertNotEquals(avant, cloture1.getDate());
		
		
		
		
	}
	
	
	
	
}
