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
import fr.afpa.formation.mecanique.entity.Pneumatique;
import fr.afpa.formation.mecanique.entity.Visibilite;
import fr.afpa.formation.mecanique.repository.ControleQualiteRepository;
import fr.afpa.formation.mecanique.repository.EclairageRepository;
import fr.afpa.formation.mecanique.repository.NiveauRepository;
import fr.afpa.formation.mecanique.repository.PneumatiqueRepository;
import fr.afpa.formation.mecanique.repository.VisibiliteRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallAppTest.class)
@DataJpaTest
public class ControleQualiteTests {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private EclairageRepository eclairageRepository;

	@Autowired
	private NiveauRepository niveauRepository;
	
	@Autowired
	private PneumatiqueRepository pneumatiqueRepository;

	@Autowired
	private VisibiliteRepository visibiliteRepository;
	
	@Autowired
	private ControleQualiteRepository controleQualiteRepository;
	
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
	}	

	@Test
	public void testEclairage() {
		Eclairage eclairage = new Eclairage(false, false, false, false, false, false, false, false);
		eclairage = eclairageRepository.save(eclairage);
		Long idEclairage = eclairage.getId();
		assertNotNull(idEclairage);
		
		eclairage = eclairageRepository.findById(idEclairage).get();
		assertNotNull(eclairage);
		
		List<Eclairage> listEclairage = (List<Eclairage>) eclairageRepository.findAll();
		assertEquals(listEclairage.size(), 2);
		
		Boolean feuxStopBefore = eclairage.getFeuxStop();
		eclairage.setFeuxStop(!eclairage.getFeuxStop());
		eclairage = eclairageRepository.save(eclairage);
		assertNotEquals(feuxStopBefore, eclairageRepository.findById(idEclairage).get().getFeuxStop());
		
		eclairageRepository.deleteById(idEclairage);
		assertFalse(eclairageRepository.findById(idEclairage).isPresent());
	}
	
	@Test
	public void testNiveau() {
		Niveau niveau = new Niveau(false, false, false, false, false);
		niveau = niveauRepository.save(niveau);
		Long idNiveau = niveau.getId();
		assertNotNull(idNiveau);
		
		niveau = niveauRepository.findById(idNiveau).get();
		assertNotNull(niveau);
		
		List<Niveau> listNiveau = (List<Niveau>) niveauRepository.findAll();
		assertEquals(listNiveau.size(), 2);
		
		Boolean laveGlaceBefore = niveau.getLaveGlace();
		niveau.setLaveGlace(!niveau.getLaveGlace());
		niveau = niveauRepository.save(niveau);
		assertNotEquals(laveGlaceBefore, niveauRepository.findById(idNiveau).get().getLaveGlace());
		
		niveauRepository.deleteById(idNiveau);
		assertFalse(niveauRepository.findById(idNiveau).isPresent());
	}
	
	@Test
	public void testPneumatique() {
		Pneumatique pneumatique = new Pneumatique(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		pneumatique = pneumatiqueRepository.save(pneumatique);
		Long idPneumatique = pneumatique.getId();
		assertNotNull(idPneumatique);
		
		pneumatique = pneumatiqueRepository.findById(idPneumatique).get();
		assertNotNull(pneumatique);
		
		List<Pneumatique> listPneumatique = (List<Pneumatique>) pneumatiqueRepository.findAll();
		assertEquals(listPneumatique.size(), 2);
		
		Integer etatPneuSecoursBefore = pneumatique.getEtatPneuSecours();
		pneumatique.setEtatPneuSecours(pneumatique.getEtatPneuSecours() + 1);
		pneumatique = pneumatiqueRepository.save(pneumatique);
		assertNotEquals(etatPneuSecoursBefore, pneumatiqueRepository.findById(idPneumatique).get().getEtatPneuSecours());
		
		pneumatiqueRepository.deleteById(idPneumatique);
		assertFalse(pneumatiqueRepository.findById(idPneumatique).isPresent());
	}
	
	@Test
	public void testVisibilite() {
		Visibilite visibilite = new Visibilite(false, false, false, false, false, false, false, false, false);
		visibilite = visibiliteRepository.save(visibilite);
		Long idVisibilite = visibilite.getId();
		assertNotNull(idVisibilite);
		
		visibilite = visibiliteRepository.findById(idVisibilite).get();
		assertNotNull(visibilite);
		
		List<Visibilite> listVisibilite = (List<Visibilite>) visibiliteRepository.findAll();
		assertEquals(listVisibilite.size(), 2);
		
		Boolean laveGlaceBefore = visibilite.getLaveGlace();
		visibilite.setLaveGlace(!visibilite.getLaveGlace());
		visibilite = visibiliteRepository.save(visibilite);
		assertNotEquals(laveGlaceBefore, visibiliteRepository.findById(idVisibilite).get().getLaveGlace());
		
		visibiliteRepository.deleteById(idVisibilite);
		assertFalse(visibiliteRepository.findById(idVisibilite).isPresent());
	}
	
	@Test
	public void testControleQualite() {
		Eclairage eclairage = new Eclairage(false, false, false, false, false, false, false, false);
		eclairage = eclairageRepository.save(eclairage);
		
		Niveau niveau = new Niveau(false, false, false, false, false);
		niveau = niveauRepository.save(niveau);
		
		Pneumatique pneumatique = new Pneumatique(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		pneumatique = pneumatiqueRepository.save(pneumatique);
		
		Visibilite visibilite = new Visibilite(false, false, false, false, false, false, false, false, false);
		visibilite = visibiliteRepository.save(visibilite);
		
		ControleQualite controleQualite = new ControleQualite(new Date(2019), 10.0, "Observation", pneumatique, eclairage, visibilite, niveau);
		controleQualite = controleQualiteRepository.save(controleQualite);
		Long idControleQualite = controleQualite.getId();
		assertNotNull(idControleQualite);
		
		controleQualite = controleQualiteRepository.findById(idControleQualite).get();
		assertNotNull(controleQualite);
		
		List<ControleQualite> listControleQualite = (List<ControleQualite>) controleQualiteRepository.findAll();
		assertEquals(listControleQualite.size(), 2);
		
		String observationBefore = controleQualite.getObservation();
		controleQualite.setObservation(controleQualite.getObservation() + "A");
		controleQualite = controleQualiteRepository.save(controleQualite);
		assertNotEquals(observationBefore, controleQualiteRepository.findById(idControleQualite).get().getObservation());
		
		controleQualiteRepository.deleteById(idControleQualite);
		assertFalse(controleQualiteRepository.findById(idControleQualite).isPresent());
	}

	@After
	public void tearDown() {}

}


