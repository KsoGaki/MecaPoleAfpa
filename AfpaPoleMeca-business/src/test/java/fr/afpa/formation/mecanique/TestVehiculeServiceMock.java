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

import fr.afpa.formation.mecanique.entity.Vehicule;
import fr.afpa.formation.mecanique.repository.VehiculeRepository;
import fr.afpa.formation.mecanique.service.VehiculeService;

@RunWith(MockitoJUnitRunner.class)
public class TestVehiculeServiceMock {

	@Mock
	private VehiculeRepository vehiculeRepositoryMock;

	@InjectMocks
	private VehiculeService vehiculeService;

	List<fr.afpa.formation.mecanique.entity.Vehicule> vehicules = new ArrayList<>();
	int itemsSize;

	@Before
	public void setUp() {

		Vehicule vehicule1 = new Vehicule(null, "Dacia", "Sandero", (Double) 15322.0, "954494", "123456789",
				"ZE-763-AX", "1234", new Date(), null);
		Vehicule vehicule2 = new Vehicule(null, "Jeep", "Renegade", (Double) 97654.3, "954494", "123456789",
				"EN-639-SV", "1234", new Date(), null);

		vehicules.add(vehicule1);
		vehicules.add(vehicule2);

		itemsSize = 2;

	}

	@Test
	public void findAll() throws Exception {
		when(vehiculeRepositoryMock.findAll()).thenReturn(vehicules);

		assertEquals(itemsSize, vehiculeService.findAll().size());

	}

}
