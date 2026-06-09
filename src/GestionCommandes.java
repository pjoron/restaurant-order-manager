import java.util.ArrayList;

// Classe qui gère l'ensemble des commandes en cours du restaurant
// Elle stocke plusieurs objets Commande dans un ArrayList
// (même principe que Menu qui gère une liste de Plat)
public class GestionCommandes {

    // La liste de toutes les commandes en cours
    private ArrayList<Commande> commandes;

    // Constructeur : on initialise la liste vide au démarrage
    public GestionCommandes() {
        commandes = new ArrayList<Commande>();
    }

    // Ajoute une nouvelle commande validée à la liste
    public void ajouterCommande(Commande commande) {
        commandes.add(commande);
    }

    // Supprime une commande selon sa position dans la liste (index à partir de 0)
    public void supprimerCommande(int index) {
        // On vérifie que l'index est valide avant de supprimer
        if (index >= 0 && index < commandes.size()) {
            commandes.remove(index);
        }
    }

    // Retourne une commande selon sa position dans la liste
    public Commande getCommande(int index) {
        // On vérifie que l'index est valide
        if (index >= 0 && index < commandes.size()) {
            return commandes.get(index);
        }
        return null;
    }

    // Retourne la liste complète des commandes en cours
    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    // Retourne le nombre de commandes en cours
    public int getNombreCommandes() {
        return commandes.size();
    }
}
