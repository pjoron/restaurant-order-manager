// Classe de base qui représente un plat du restaurant
public class Plat {

    // Le nom du plat affiché sur le menu
    private String nom;

    // Le prix en euros du plat
    private double prix;

    // Une courte description du plat
    private String description;

    // Constructeur : on crée un plat avec son nom, son prix et sa description
    public Plat(String nom, double prix, String description) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
    }

    // Retourne le nom du plat
    public String getNom() {
        return nom;
    }

    // Retourne le prix du plat
    public double getPrix() {
        return prix;
    }

    // Retourne la description du plat
    public String getDescription() {
        return description;
    }

    // Affiche les informations du plat dans la console
    public void afficher() {
        System.out.println("  - " + nom + " (" + prix + " EUR) : " + description);
    }
}
