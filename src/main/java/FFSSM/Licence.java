/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    private Personne possesseur;
    private String numero;
    private LocalDate delivrance;
    private Club emetteur;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club emetteur) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.emetteur = emetteur;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getEmetteur() {
        return emetteur;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
        LocalDate dateLimite = delivrance.plusYears(1);
        if (d.isBefore(dateLimite)){
            return true;
        }
        return false;
    }

}
