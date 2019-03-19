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

import fr.afpa.formation.mecanique.entity.Devis;
import fr.afpa.formation.mecanique.entity.Fournisseur;
import fr.afpa.formation.mecanique.entity.ItemDevis;
import fr.afpa.formation.mecanique.entity.Piece;
import fr.afpa.formation.mecanique.repository.DevisRepository;
import fr.afpa.formation.mecanique.repository.FournisseurRepository;
import fr.afpa.formation.mecanique.repository.ItemDevisRepository;
import fr.afpa.formation.mecanique.repository.PieceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SmallApp.class)
@DataJpaTest
public class DevisTestUnitaire {

	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private DevisRepository devisRepo;
	
	@Autowired
	private ItemDevisRepository itemDevisRepo;
	
	@Autowired
	private PieceRepository pieceRepo;
	
	@Autowired
	private FournisseurRepository fournisseurRepo;
	
	
	@Before
	public void setUp() {
		
		Date crea = new Date();
		Date paie = new Date();
		
		Fournisseur fournisseur = new Fournisseur("test-Code", "test-nom");
		Fournisseur fournisseur2 = new Fournisseur("test-Code1", "test-nom1");
		entityManager.persist(fournisseur);
		entityManager.persist(fournisseur2);
		
		
		Devis devis1 = new Devis(crea, "Numero1",paie, fournisseur);
		Devis devis2 = new Devis(crea, "Numero2",paie, fournisseur2);
		entityManager.persist(devis1);
		entityManager.persist(devis2);
		
		Piece piece1 = new Piece("reference-test","libelle-test", 1.5);
		Piece piece2 = new Piece("reference-test1","libelle-test1", 1.8);
		entityManager.persist(piece1);
		entityManager.persist(piece2);
		
		ItemDevis itemDevis1 = new ItemDevis(10,devis1, piece1);
		ItemDevis itemDevis2 = new ItemDevis(20,devis2, piece2);
		entityManager.persist(itemDevis1);
		entityManager.persist(itemDevis2);
	}
	//////////////|||TEST FOURNISSEUR|||\\\\\\\\\\\\\\\\\\\\
	@Test
	public void findAll() {
		List<Fournisseur> listFourni = (List<Fournisseur>) fournisseurRepo.findAll();
		assertNotNull(listFourni);
		assertEquals(2,listFourni.size());
	}
	@Test
	public void testCreate() {
		String code = "fourni-code";
		String nom = "fourni-nom";
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		fournisseurRepo.save(fournisseurTest);
		assertNotNull(fournisseurTest);
		assertEquals(code, fournisseurTest.getCode());
		assertEquals(nom, fournisseurTest.getNom());
		
		Fournisseur fournisseurTest1 = new Fournisseur("code-test","nom-test");
		fournisseurRepo.save(fournisseurTest1);
		assertNotNull(fournisseurTest1);
		assertEquals("code-test", fournisseurTest1.getCode());
		assertEquals("nom-test", fournisseurTest1.getNom());
		assertNotEquals(code, fournisseurTest1.getCode());
		assertNotEquals(nom, fournisseurTest1.getNom());
	}
	
	
	@Test
	public void testUpdateAndFindId() {
		String code = "fourni-code";
		String nom = "fourni-nom";
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		
		
		assertNotNull(fournisseurTest);
		fournisseurRepo.save(fournisseurTest);
		Long id = fournisseurTest.getId();
		assertEquals(id,fournisseurRepo.findById(id).get().getId());
		
		Fournisseur getId = fournisseurRepo.findById(id).get();
		assertNotNull(getId);
		assertEquals(code, getId.getCode());
		
		String code1 = fournisseurTest.getCode() + "test";
		fournisseurTest.setCode(fournisseurTest.getCode() + "test");
		fournisseurTest = fournisseurRepo.save(fournisseurTest);
		assertNotEquals(code, code1);	
		
	}
	
	@Test
	public void testDelete() {
		String code = "fourni-code";
		String nom = "fourni-nom";
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		assertNotNull(fournisseurTest);
		
		fournisseurRepo.save(fournisseurTest);
		Long id = fournisseurTest.getId();
		assertEquals(code, fournisseurTest.getCode());
		
		List<Fournisseur> listFourni = (List<Fournisseur>) fournisseurRepo.findAll();
		assertEquals(3, listFourni.size());
		
		fournisseurRepo.deleteById(id);
		 listFourni = (List<Fournisseur>) fournisseurRepo.findAll();
		assertEquals(2, listFourni.size());
	}
	
	/////////////////////////||TEST PIECE||\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@Test
	public void findAllPiece() {
		List<Piece> listPiece = (List<Piece>) pieceRepo.findAll();
		assertNotNull(listPiece);
		assertEquals(2,listPiece.size());
	}
	@Test
	public void testCreatePiece() {
		String lib = "Piece-lib";
		String ref = "Piece-ref";
		Piece pieceTest = new Piece(lib,ref,1.8);
		pieceRepo.save(pieceTest);
		assertNotNull(pieceTest);
		assertEquals(ref, pieceTest.getLibelle());
		assertEquals(lib, pieceTest.getReference());
		
		Piece pieceTest1 = new Piece("lib-test","ref-test",2.1);
		pieceRepo.save(pieceTest1);
		assertNotNull(pieceTest1);
		assertEquals("ref-test", pieceTest1.getLibelle());
		assertEquals("lib-test", pieceTest1.getReference());
		assertNotEquals(ref, pieceTest1.getLibelle());
		assertNotEquals(lib, pieceTest1.getReference());
	}	
	
	@Test
	public void testUpdateAndFindIdPiece() {
		String lib = "Piece-lib";
		String ref = "Piece-ref";		
		Piece pieceTest = new Piece(lib,ref,3.3);
		assertNotNull(pieceTest);
		pieceRepo.save(pieceTest);
		Long id = pieceTest.getId();
		assertEquals(id,pieceRepo.findById(id).get().getId());
		
		Piece getId = pieceRepo.findById(id).get();
		assertNotNull(getId);
		assertEquals(ref, getId.getLibelle());
		
		String lib1 = pieceTest.getLibelle() + "test";
		pieceTest.setLibelle(pieceTest.getLibelle() + "test");
		pieceTest = pieceRepo.save(pieceTest);
		assertNotEquals(lib, lib1);			
	}	
	@Test
	public void testDeletePiece () {
		String lib = "Piece-lib";
		String ref = "Piece-ref";
		
		Piece pieceTest = new Piece(lib,ref,3.3);
		
		assertNotNull(pieceTest);
		
		pieceRepo.save(pieceTest);
		Long id = pieceTest.getId();
		assertEquals(ref, pieceTest.getLibelle());
		
		List<Piece> listPiece = (List<Piece>) pieceRepo.findAll();
		assertEquals(3, listPiece.size());
		
		pieceRepo.deleteById(id);
		listPiece = (List<Piece>) pieceRepo.findAll();
		assertEquals(2, listPiece.size());
	}
	
	////////////////////////||TEST DEVIS||\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	@Test
	public void findAllDevis() {
		List<Devis> listDevis = (List<Devis>) devisRepo.findAll();
		assertNotNull(listDevis);
		assertEquals(2,listDevis.size());
	}
	@Test
	public void testCreateDevis() {
		String numero = "devis-num";
		Date crea = new Date();
		Date paie = new Date();
		
		String code = "fourni-code";
		String nom = "fourni-nom";
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		fournisseurRepo.save(fournisseurTest);
		Devis devisTest = new Devis(crea,numero,paie,fournisseurTest);
		devisRepo.save(devisTest);
		assertNotNull(devisTest);
		assertEquals(numero, devisTest.getNumero());
		assertEquals(code, devisTest.getFournisseur().getCode());
		
		
	}	
	
	@Test
	public void testUpdateAndFindIdDevis() {
		String numero = "devis-num";
		Date crea = new Date();
		Date paie = new Date();		
		String code = "fourni-code";
		String nom = "fourni-nom";
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		fournisseurRepo.save(fournisseurTest);
		Devis devisTest = new Devis(crea,numero,paie,fournisseurTest);
		assertNotNull(devisTest);
		devisRepo.save(devisTest);
		
		Long id = devisTest.getId();
		assertEquals(id,devisRepo.findById(id).get().getId());
		
		Devis getId = devisRepo.findById(id).get();
		assertNotNull(getId);
		assertEquals(numero, getId.getNumero());
		
		String num1 = devisTest.getNumero() + "test";
		devisTest.setNumero(devisTest.getNumero() + "test");
		devisTest = devisRepo.save(devisTest);
		assertNotEquals(numero, num1);			
	}	
	@Test
	public void testDeleteDevis () {
		String numero = "devis-num";
		Date crea = new Date();
		Date paie = new Date();		
		String code = "fourni-code";
		String nom = "fourni-nom";
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		fournisseurRepo.save(fournisseurTest);
		Devis devisTest = new Devis(crea,numero,paie,fournisseurTest);
		assertNotNull(devisTest);
		devisRepo.save(devisTest);
		
		Long id = devisTest.getId();
		assertEquals(numero, devisTest.getNumero());
		
		List<Devis> listDevis = (List<Devis>) devisRepo.findAll();
		assertEquals(3, listDevis.size());
		
		devisRepo.deleteById(id);
		listDevis = (List<Devis>) devisRepo.findAll();
		assertEquals(2, listDevis.size());
	}
	
	//////////////////||TEST ITEM DEVIS||\\\\\\\\\\\\\\\\\\\
	@Test
	public void findAllItemDevis() {
		List<ItemDevis> listItemDevis = (List<ItemDevis>) itemDevisRepo.findAll();
		assertNotNull(listItemDevis);
		assertEquals(2,listItemDevis.size());
	}
	@Test
	public void testCreateItemDevis() {
		String numero = "devis-num";
		String code = "fourni-code";
		String nom = "fourni-nom";
		String lib = "Piece-lib";
		String ref = "Piece-ref";
		
		Date crea = new Date();
		Date paie = new Date();
		Integer quantiTest = 10;
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		fournisseurRepo.save(fournisseurTest);
		
		Devis devisTest = new Devis(crea,numero,paie,fournisseurTest);
		devisRepo.save(devisTest);
		
		Piece pieceTest = new Piece(lib,ref,1.8);
		pieceRepo.save(pieceTest);		
		
		ItemDevis itemTest = new ItemDevis(quantiTest,devisTest,pieceTest);
		itemDevisRepo.save(itemTest);
		
		assertNotNull(fournisseurTest);
		assertNotNull(pieceTest);
		assertNotNull(devisTest);
		assertNotNull(itemTest);
		assertEquals(quantiTest, itemTest.getQuantite());
		assertEquals(ref, itemTest.getPiece().getLibelle());
		assertEquals(code, itemTest.getDevis().getFournisseur().getCode());
		
		
	}	
	
	@Test
	public void testUpdateAndFindIdItemDevis() {
		String numero = "devis-num";
		String code = "fourni-code";
		String nom = "fourni-nom";
		String lib = "Piece-lib";
		String ref = "Piece-ref";
		
		Date crea = new Date();
		Date paie = new Date();
		Integer quantiTest = 10;
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		fournisseurRepo.save(fournisseurTest);
		
		Devis devisTest = new Devis(crea,numero,paie,fournisseurTest);
		devisRepo.save(devisTest);
		
		Piece pieceTest = new Piece(lib,ref,1.8);
		pieceRepo.save(pieceTest);		
		
		ItemDevis itemTest = new ItemDevis(quantiTest,devisTest,pieceTest);
		itemDevisRepo.save(itemTest);
		
		Long id = itemTest.getId();
		assertEquals(id,itemDevisRepo.findById(id).get().getId());
		
		ItemDevis getId = itemDevisRepo.findById(id).get();
		assertNotNull(getId);
		assertEquals(quantiTest, getId.getQuantite());
		
		Integer num1 = itemTest.getQuantite() + 1;
		itemTest.setQuantite(itemTest.getQuantite() + 1);
		itemTest = itemDevisRepo.save(itemTest);
		assertNotEquals(quantiTest, num1);			
	}	
	@Test
	public void testDeleteItemDevis () {
		String numero = "devis-num";
		String code = "fourni-code";
		String nom = "fourni-nom";
		String lib = "Piece-lib";
		String ref = "Piece-ref";
		
		Date crea = new Date();
		Date paie = new Date();
		Integer quantiTest = 10;
		
		Fournisseur fournisseurTest = new Fournisseur(code,nom);
		fournisseurRepo.save(fournisseurTest);
		
		Devis devisTest = new Devis(crea,numero,paie,fournisseurTest);
		devisRepo.save(devisTest);
		
		Piece pieceTest = new Piece(lib,ref,1.8);
		pieceRepo.save(pieceTest);		
		
		ItemDevis itemTest = new ItemDevis(quantiTest,devisTest,pieceTest);
		itemDevisRepo.save(itemTest);
		
		
		Long id = itemTest.getId();
		assertEquals(quantiTest, itemTest.getQuantite());
		
		List<ItemDevis> listItemDevis = (List<ItemDevis>) itemDevisRepo.findAll();
		assertEquals(3, listItemDevis.size());
		
		itemDevisRepo.deleteById(id);
		listItemDevis = (List<ItemDevis>) itemDevisRepo.findAll();
		assertEquals(2, listItemDevis.size());
	}
	
	
	
}
