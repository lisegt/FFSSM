/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;

public class Club {

 
    private Moniteur president;
    private String nom;
    private String adresse;
    private String telephone;
    private Set<Plongee> activites = new HashSet<>();
    private Set<Licence> licencesDelivrees = new HashSet<>();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
        Set<Plongee> nonConformes = new HashSet<>();
        for (Plongee p : activites){
            if (!p.estConforme()){
                nonConformes.add(p);
            }
        }
        return nonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        activites.add(p);
    }

    /**
     * Ajoute une licence pour un club
     * @param l la nouvelle licence
     */
    public void ajouteLicence(Licence l) {
        licencesDelivrees.add(l);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur president) {
        this.president = president;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Plongee> getActivites() {
        return activites;
    }

    public void setActivites(Set<Plongee> activites) {
        this.activites = activites;
    }

    public Set<Licence> getLicencesDelivrees() {
        return licencesDelivrees;
    }

    public void setLicencesDelivrees(Set<Licence> licencesDelivrees) {
        this.licencesDelivrees = licencesDelivrees;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
