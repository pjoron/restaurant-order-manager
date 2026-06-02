import java.util.ArrayList;

// Classe qui représente une commande passée par un client
public class Commande {

    // Le numéro de la table du client
    private int numeroTable;

    // La liste des plats commandés par le client
    private ArrayList<Plat> platsCommandes;

    // Constructeur : on crée une commande pour une table donnée
    public Commande(int numeroTable) {
        this.numeroTable = numeroTable;
        platsCommandes = new ArrayList<Plat>();
    }

    // Ajoute un plat à la commande
    public void ajouterPlat(Plat plat) {
        platsCommandes.add(plat);
        System.out.println("  ✔ '" + plat.getNom() + "' ajouté à la commande.");
    }

    // Supprime le dernier plat ajouté à la commande
    public void supprimerDernierPlat() {
        // On vérifie que la commande n'est pas vide avant de supprimer
        if (platsCommandes.size() > 0) {
            Plat supprime = platsCommandes.remove(platsCommandes.size() - 1);
            System.out.println("  ✘ '" + supprime.getNom() + "' retiré de la commande.");
        } else {
            System.out.println("  La commande est déjà vide.");
        }
    }

    // Calcule et retourne le prix total de tous les plats commandés
    public double calculerTotal() {
        double total = 0.0;
        // On additionne le prix de chaque plat avec une boucle for
        for (Plat p : platsCommandes) {
            total = total + p.getPrix();
        }
        return total;
    }

    // Retourne le nombre de plats dans la commande
    public int getNombrePlats() {
        return platsCommandes.size();
    }

    // Affiche le récapitulatif complet de la commande avec le total
    public void afficherRecapitulatif() {
        System.out.println("\n====== RÉCAPITULATIF DE LA COMMANDE ======");
        System.out.println("  Table n°" + numeroTable);

        // Si la commande est vide, on l'indique
        if (platsCommandes.size() == 0) {
            System.out.println("  Aucun plat commandé.");
        } else {
            // On affiche chaque plat commandé avec une boucle
            for (int i = 0; i < platsCommandes.size(); i++) {
                Plat p = platsCommandes.get(i);
                System.out.println("  " + (i + 1) + ". " + p.getNom() + " - " + p.getPrix() + " EUR");
            }
            System.out.println("  ----------------------------------------");
            System.out.printf("  TOTAL : %.2f EUR%n", calculerTotal());
        }

        System.out.println("==========================================");
    }
}
