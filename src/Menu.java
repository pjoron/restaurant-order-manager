import java.util.ArrayList;

// Classe qui représente le menu du restaurant
// Elle contient la liste de tous les plats et boissons disponibles
public class Menu {

    // On utilise un ArrayList pour stocker tous les plats du menu
    private ArrayList<Plat> plats;

    // Constructeur : on initialise la liste et on ajoute les plats par défaut
    public Menu() {
        plats = new ArrayList<Plat>();
        initialiserMenu();
    }

    // Méthode privée qui remplit le menu avec les plats de départ
    private void initialiserMenu() {
        // Ajout des entrées
        plats.add(new Plat("Soupe à l'oignon", 6.50, "Soupe gratinée traditionnelle"));
        plats.add(new Plat("Salade César", 8.00, "Salade romaine, croûtons et parmesan"));

        // Ajout des plats principaux
        plats.add(new Plat("Steak frites", 15.00, "Steak 200g avec frites maison"));
        plats.add(new Plat("Poulet rôti", 13.50, "Demi poulet rôti avec légumes de saison"));
        plats.add(new Plat("Saumon grillé", 16.00, "Filet de saumon avec riz et citron"));

        // Ajout des desserts
        plats.add(new Plat("Crème brûlée", 5.50, "Crème brûlée à la vanille"));
        plats.add(new Plat("Tarte au chocolat", 5.00, "Tarte fondante au chocolat noir"));

        // Ajout des boissons (classe Boisson hérite de Plat)
        plats.add(new Boisson("Eau minérale", 2.00, "Eau plate ou gazeuse", "moyen"));
        plats.add(new Boisson("Jus d'orange", 3.50, "Jus d'orange pressé frais", "grand"));
        plats.add(new Boisson("Coca-Cola", 3.00, "Boisson gazeuse froide", "moyen"));
    }

    // Retourne la liste des plats
    public ArrayList<Plat> getPlats() {
        return plats;
    }

    // Retourne un plat selon son numéro dans la liste (index à partir de 1)
    public Plat getPlatParNumero(int numero) {
        // On vérifie que le numéro est valide
        if (numero >= 1 && numero <= plats.size()) {
            return plats.get(numero - 1);
        }
        return null;
    }

    // Affiche tous les plats du menu dans la console
    public void afficherMenu() {
        System.out.println("\n========== MENU DU RESTAURANT ==========");
        int i = 1;
        // On parcourt la liste avec une boucle for
        for (Plat p : plats) {
            System.out.print("  [" + i + "] ");
            p.afficher();
            i++;
        }
        System.out.println("=========================================");
    }
}
