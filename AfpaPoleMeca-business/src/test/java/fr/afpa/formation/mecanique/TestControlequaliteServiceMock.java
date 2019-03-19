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

import fr.afpa.formation.mecanique.entity.ControleQualite;
import fr.afpa.formation.mecanique.repository.ControleQualiteRepository;
import fr.afpa.formation.mecanique.service.ControleQualiteService;

@RunWith(MockitoJUnitRunner.class)
public class TestControlequaliteServiceMock {

	@Mock
	private ControleQualiteRepository controleQualiteRepositoryMock;

	@InjectMocks
	private ControleQualiteService controleQualiteService;

	List<fr.afpa.formation.mecanique.entity.ControleQualite> controleQualites = new ArrayList<>();
	int itemsSize;

	@Before
	public void setUp() {

		ControleQualite controleQualite1 = new ControleQualite(null, new Date(), (Double) 15322.0, "RAS", null, null,
				null, null);
		ControleQualite controleQualite2 = new ControleQualite(null, new Date(), (Double) 85432.5, "Pneus usés à 70%",
				null, null, null, null);

		controleQualites.add(controleQualite1);
		controleQualites.add(controleQualite2);

		itemsSize = 2;

	}

	@Test
	public void findAll() throws Exception {
		when(controleQualiteRepositoryMock.findAll()).thenReturn(controleQualites);

		assertEquals(itemsSize, controleQualiteService.findAll().size());

	}

}
