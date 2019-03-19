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

import fr.afpa.formation.mecanique.entity.Devis;
import fr.afpa.formation.mecanique.entity.Fournisseur;
import fr.afpa.formation.mecanique.entity.TypePaiement;
import fr.afpa.formation.mecanique.repository.DevisRepository;
import fr.afpa.formation.mecanique.service.DevisService;

@RunWith(MockitoJUnitRunner.class)
public class DevisServiceTestMock {

	@Mock
	private DevisRepository devisRepoMock;

	@InjectMocks
	private DevisService devisService;

	List<Devis> devisList = new ArrayList<Devis>();
	int listSize;

	@Before
	public void setUp() {
		Date dateCreation = new Date();
		Date datePaiement = new Date();
		Fournisseur fourni1 = new Fournisseur("CodeFournisseur1","NomFournisseur1");
		Fournisseur fourni2 = new Fournisseur("CodeFournisseur2","NomFournisseur2");
		Fournisseur fourni3 = new Fournisseur("CodeFournisseur3","NomFournisseur3");

		TypePaiement type1 = new TypePaiement("type1");
		TypePaiement type2 = new TypePaiement("type2");
		TypePaiement type3 = new TypePaiement("type3");

		Devis devis1 = new Devis(dateCreation, "NumeroDevis1", datePaiement, fourni1,type1);
		Devis devis2 = new Devis(dateCreation, "NumeroDevis2", datePaiement, fourni2,type2);
		Devis devis3 = new Devis(dateCreation, "NumeroDevis3", datePaiement, fourni3,type3);

		devisList.add(devis1);
		devisList.add(devis2);
		devisList.add(devis3);
		listSize = 3;


	}
	
	
	@Test
	public void findAll() throws Exception {
		when( devisRepoMock.findAll()).thenReturn(devisList);
		
		assertEquals(listSize, devisService.findAll().size());
	}
	
	
	
	
	
	
	
	
	


}
