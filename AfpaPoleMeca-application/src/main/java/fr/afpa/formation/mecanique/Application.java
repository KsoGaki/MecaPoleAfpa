package fr.afpa.formation.mecanique;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.afpa.formation.mecanique.entity.Client;
import fr.afpa.formation.mecanique.service.ClientService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	ClientService service;

    public static void main(String[] args)  {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//init();
		
	}
	
	public void init() throws Exception {
		
		Client client1 = new Client(null, "jv.gmail.com", "VALJEAN", "Jean", "0213243546", "451267", "2 345 678 3",
				new Date(), "N", null);
		service.create(client1);
		
		Client client2 = new Client(null, "jd.gmail.com", "DUPOND", "Jacques", "1314151617", "368992", "1 234 526 2",
				new Date(), "O",null);
		
		service.create(client1);
		service.create(client2);
		
		
	}

}
