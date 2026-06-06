import java.util.Scanner;

// Classe principale : point d'entrée du programme
// Gère le menu interactif en console avec Scanner
public class Main {

    public static void main(String[] args) {

        // On crée le menu du restaurant (chargé automatiquement)
        Menu menu = new Menu();

        // On crée un Scanner pour lire les saisies de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("  BIENVENUE AU RESTAURANT JAVA BISTRO");
        System.out.println("==========================================");

        // On demande le numéro de table au client
        System.out.print("\nEntrez le numéro de votre table : ");
        int numeroTable = scanner.nextInt();

        // On crée une nouvelle commande pour cette table
        Commande commande = new Commande(numeroTable);

        // Variable de contrôle de la boucle principale
        boolean continuer = true;

        // Boucle principale du programme : affiche le menu jusqu'à ce que l'utilisateur quitte
        while (continuer) {

            // Affichage du menu principal de navigation
            System.out.println("\n---------- QUE VOULEZ-VOUS FAIRE ? ----------");
            System.out.println("  [1] Voir le menu du restaurant");
            System.out.println("  [2] Ajouter un plat à la commande");
            System.out.println("  [3] Retirer le dernier plat ajouté");
            System.out.println("  [4] Voir ma commande");
            System.out.println("  [5] Valider et quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();

            // On traite le choix avec un switch
            switch (choix) {

                case 1:
                    // Affiche tous les plats disponibles
                    menu.afficherMenu();
                    break;

                case 2:
                    // Affiche le menu et demande quel plat ajouter
                    menu.afficherMenu();
                    System.out.print("Entrez le numéro du plat à ajouter : ");
                    int numeroplat = scanner.nextInt();
                    Plat platChoisi = menu.getPlatParNumero(numeroplat);

                    // On vérifie que le plat existe bien dans le menu
                    if (platChoisi != null) {
                        commande.ajouterPlat(platChoisi);
                    } else {
                        System.out.println("  Numéro invalide, veuillez réessayer.");
                    }
                    break;

                case 3:
                    // Retire le dernier plat ajouté
                    commande.supprimerDernierPlat();
                    break;

                case 4:
                    // Affiche le récapitulatif de la commande
                    commande.afficherRecapitulatif();
                    break;

                case 5:
                    // On valide la commande si elle n'est pas vide
                    if (commande.getNombrePlats() == 0) {
                        System.out.println("\n  Votre commande est vide. Ajoutez des plats avant de valider.");
                    } else {
                        commande.afficherRecapitulatif();
                        System.out.println("\n  Votre commande a été envoyée en cuisine. Bon appétit !");
                        continuer = false;
                    }
                    break;

                default:
                    // Cas où le choix ne correspond à aucune option
                    System.out.println("  Choix invalide. Entrez un numéro entre 1 et 5.");
                    break;
            }
        }

        // On ferme le Scanner à la fin du programme
        scanner.close();
        System.out.println("==========================================");
        System.out.println("  Merci et à bientôt au Restaurant Java Bistro !");
        System.out.println("==========================================");
    }
}
