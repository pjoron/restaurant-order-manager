import javax.swing.*;

// Classe principale : point d'entrée du programme
// Lance l'interface graphique Swing (GUI - Week03)
public class Main {

    public static void main(String[] args) {

        // On lance l'interface graphique dans le thread Swing (bonne pratique)
        // SwingUtilities.invokeLater assure que la fenêtre est créée dans le bon thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // On crée et affiche la fenêtre principale du restaurant
                new FenetreRestaurant();
            }
        });
    }
}
