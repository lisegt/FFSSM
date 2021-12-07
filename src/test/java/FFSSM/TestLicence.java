package FFSSM;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TestLicence {
    Club club;
	Moniteur president;
    Licence licenceValide, licenceNonValide;
    Personne personne1, personne2;
		
	@BeforeEach
	public void setUp() {
    
        //création club
        club = new Club(president, "Club1", "0640196743");

        //création personnes
        personne1 = new Personne("43683426", "unNom", "Luc", "adresse de Luc", "0742555567", LocalDate.of(2003, 05, 9));
        personne2 = new Personne("45636357", "Untel", "Marc", "adresse de Marc", "0683567819", LocalDate.of(2001, 05, 10));

        //création licence valide
        licenceValide = new Licence(personne1, "1", LocalDate.of(2021, 10, 07), club);

        //création licence non valide
        licenceNonValide = new Licence(personne2, "2", LocalDate.of(2020, 10, 07), club);

	}

	@Test
	public void testLicenceValide() {
		assertTrue(licenceValide.estValide(LocalDate.of(2021, 12, 7)));
	}

    @Test
	public void testLicenceNonValide() {
		assertFalse(licenceNonValide.estValide(LocalDate.of(2021, 12, 7)));
	}

}
