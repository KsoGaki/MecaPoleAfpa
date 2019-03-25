package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fr.afpa.formation.mecanique.entity.Stagiaire;
import fr.afpa.formation.mecanique.repository.StagiaireRepository;
import fr.afpa.formation.mecanique.service.StagiaireService;

@RunWith(MockitoJUnitRunner.class)
public class TestStagiaireServiceMock {

	@Mock
	private StagiaireRepository stagiaireRepositoryMock;

	@InjectMocks
	private StagiaireService stagiaireService;

	List<fr.afpa.formation.mecanique.entity.Stagiaire> stagiaires = new ArrayList<>();
	int itemsSize;

	@Before
	public void setUp() {

		Stagiaire stagiaire1 = new Stagiaire("jv.gmail.com", "VALJEAN", "Jean", "04 68 14 23 45", "12434187",
				"mot de passe", new Date(), new Date(),null, "2 345 678 3",null);
		Stagiaire stagiaire2 = new Stagiaire("jd.gmail.com", "DUPONT", "Jean", "04 67 14 23 45", "12435687",
				"mot de passe2", new Date(), new Date(),null, "2 345 678 4",null);

		stagiaires.add(stagiaire1);
		stagiaires.add(stagiaire2);

		itemsSize = 2;

	}

	@Test
	public void findAll() throws Exception {
		when(stagiaireRepositoryMock.findAll()).thenReturn(stagiaires);

		assertEquals(itemsSize, stagiaireService.findAll().size());

	}

}
