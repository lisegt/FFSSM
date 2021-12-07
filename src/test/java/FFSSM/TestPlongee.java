package FFSSM;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TestPlongee {
    Club club;
	Moniteur president, moniteur;
    Plongeur plongeurValide1, plongeurValide2, plongeurNonValide;
    Plongee plongeeConforme, plongeeNonConforme;
		
	@BeforeEach
	public void setUp() {
        //création président
        president = new Moniteur( "12345", "Matton", "Hugo", "adresse d'Hugo", "0657869479", LocalDate.of(2001, 05, 06), 2, GroupeSanguin.AMOINS, 123456);
		
        //création club
        club = new Club(president, "Club1", "0640196743");

        //création moniteur
        moniteur = new Moniteur("98765", "Bencharef", "Rayane", "adresse de Rayane", "0673546575", LocalDate.of(2001, 01, 3), 5, GroupeSanguin.BMOINS, 764336);

        //création plongeurs avec licence valide
        plongeurValide1 = new Plongeur("547457", "Untel", "Marc", "adresse de Marc", "0783945678", LocalDate.of(1970, 03, 05), 1, GroupeSanguin.BPLUS);
        plongeurValide1.ajouteLicence("1", LocalDate.of(2021, 01, 07), club);
        plongeurValide2 = new Plongeur("426245", "Truc", "Charles", "adresse de Charles", "0783426547", LocalDate.of(1960,06, 01), 2, GroupeSanguin.BPLUS);
        plongeurValide2.ajouteLicence("2", LocalDate.of(2021, 10, 07), club);
        
        //création plongeur avec licence non valide
        plongeurNonValide = new Plongeur("865378", "Machin", "Jules", "adresse de Jules", "0684333333", LocalDate.of(1990, 02, 02), 3, GroupeSanguin.BMOINS);
        plongeurNonValide.ajouteLicence("3", LocalDate.of(2017, 9, 01), club);
        
        //création plongée conforme
        plongeeConforme = new Plongee(new Site("Castres", "Lieu1"), moniteur, LocalDate.of(2021, 11, 7), 100, 1);

        //création plongée non conforme : participant sans licence valide
        plongeeNonConforme = new Plongee(new Site("Castres", "Lieu3"), moniteur, LocalDate.of(2021, 10, 3), 300, 1);
        plongeeNonConforme.ajouteParticipant(plongeurValide1);
        plongeeNonConforme.ajouteParticipant(plongeurNonValide);

	}

    @Test
	public void testAjouterParticipant() {
        plongeeConforme.ajouteParticipant(plongeurValide1);
        plongeeConforme.ajouteParticipant(plongeurValide2);
		assertEquals(2, plongeeConforme.getPalanquee().size(), "La plongée doit avoir 2 participants");
	}

    @Test
	public void testEstConforme() {
        //on ajoute un participant ayant une licence valide dans une plongée qui doit donc être conforme
        plongeeConforme.ajouteParticipant(plongeurValide1);
        assertTrue(plongeeConforme.estConforme(), "La plongée doit être conforme");

        //on ajoute un participant ayant une licence non valide dans une plongée qui doit donc être non conforme
        plongeeConforme.ajouteParticipant(plongeurNonValide);
		assertFalse(plongeeNonConforme.estConforme(), "La plongée ne doit pas être conforme");
	}

}
