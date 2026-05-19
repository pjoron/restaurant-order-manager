// Classe Boisson hérite de Plat (concept d'héritage vu en cours)
// Une boisson est un type de plat, mais avec une taille en plus
public class Boisson extends Plat {

    // La taille de la boisson : "petit", "moyen" ou "grand"
    private String taille;

    // Constructeur : on appelle le constructeur de Plat avec super()
    public Boisson(String nom, double prix, String description, String taille) {
        super(nom, prix, description);
        this.taille = taille;
    }

    // Retourne la taille de la boisson
    public String getTaille() {
        return taille;
    }

    // On redéfinit la méthode afficher() pour inclure la taille (méthode overriding)
    @Override
    public void afficher() {
        System.out.println("  - " + getNom() + " [" + taille + "] (" + getPrix() + " EUR) : " + getDescription());
    }
}
