import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

// Classe principale de l'interface graphique
// Hérite de JFrame (concept d'héritage vu en cours - Week03)
public class FenetreRestaurant extends JFrame {

    // Le menu du restaurant (liste de tous les plats disponibles)
    private Menu menu;

    // La commande en cours de saisie pour la table actuelle
    private Commande commande;

    // Gestionnaire de toutes les commandes validées (commandes en cours dans le restaurant)
    private GestionCommandes gestionCommandes;

    // --- Composants Swing de l'interface ---

    // Champ de saisie pour le numéro de table (JTextField)
    private JTextField champNumeroTable;

    // Liste graphique des plats du menu (JList avec JScrollPane)
    private JList<String> listeMenu;

    // Zone de texte pour afficher la commande en cours de saisie (JTextArea)
    private JTextArea zoneCommande;

    // Étiquette affichant le total de la commande en cours (JLabel)
    private JLabel labelTotal;

    // Boutons d'action pour la commande en cours (JButton)
    private JButton boutonAjouter;
    private JButton boutonRetirer;
    private JButton boutonValider;

    // Liste graphique des commandes validées en cours (JList)
    private JList<String> listeCommandes;

    // Modèle de données de la liste des commandes en cours
    private DefaultListModel<String> modeleCommandes;

    // Boutons d'action pour les commandes en cours
    private JButton boutonAfficherCommande;
    private JButton boutonSupprimerCommande;

    // Constructeur : construit toute la fenêtre
    public FenetreRestaurant() {

        // On initialise le menu du restaurant
        menu = new Menu();

        // On initialise le gestionnaire de commandes (vide au départ)
        gestionCommandes = new GestionCommandes();

        // Aucune commande en cours de saisie au démarrage
        commande = null;

        // --- Configuration de la fenêtre principale (JFrame) ---
        setTitle("Restaurant Java Bistro");
        setSize(1050, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création de la barre de menu (JMenuBar)
        creerBarreMenu();

        // Création du contenu central de la fenêtre
        creerContenu();

        // On rend la fenêtre visible
        setVisible(true);
    }

    // Méthode privée : crée la barre de menu en haut de la fenêtre
    private void creerBarreMenu() {

        // On crée la barre de menus (JMenuBar)
        JMenuBar barreMenu = new JMenuBar();

        // Premier menu : "Fichier"
        JMenu menuFichier = new JMenu("Fichier");

        // Élément "Nouvelle commande" pour réinitialiser la saisie
        JMenuItem itemNouvelle = new JMenuItem("Nouvelle commande");
        itemNouvelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preparerNouvelleCommande();
            }
        });

        // Élément "Quitter" pour fermer l'application
        JMenuItem itemQuitter = new JMenuItem("Quitter");
        itemQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuFichier.add(itemNouvelle);
        menuFichier.addSeparator();
        menuFichier.add(itemQuitter);

        // Deuxième menu : "Aide"
        JMenu menuAide = new JMenu("Aide");

        // Élément "À propos" : affiche une boîte de dialogue (JOptionPane)
        JMenuItem itemAPropos = new JMenuItem("À propos");
        itemAPropos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    FenetreRestaurant.this,
                    "Restaurant Java Bistro\n" +
                    "Application de gestion de commandes\n" +
                    "Réalisée en Java avec Swing",
                    "À propos",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        menuAide.add(itemAPropos);

        // On ajoute les menus à la barre
        barreMenu.add(menuFichier);
        barreMenu.add(menuAide);

        // On attache la barre de menus à la fenêtre
        setJMenuBar(barreMenu);
    }

    // Méthode privée : crée et organise tous les composants graphiques
    private void creerContenu() {

        // Panneau principal avec organisation BorderLayout
        JPanel panneauPrincipal = new JPanel(new BorderLayout(10, 10));
        panneauPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ---- PANNEAU DU HAUT : titre et saisie du numéro de table ----
        JPanel panneauHaut = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        // Titre principal de l'application (JLabel)
        JLabel labelTitre = new JLabel("Restaurant Java Bistro");
        labelTitre.setFont(new Font("Arial", Font.BOLD, 20));

        // Séparateur visuel
        JLabel separateur = new JLabel(" | ");

        // Étiquette et champ pour le numéro de table
        JLabel labelTable = new JLabel("Numéro de table :");
        champNumeroTable = new JTextField(5);

        // Bouton pour confirmer le numéro de table
        JButton boutonConfirmerTable = new JButton("Confirmer la table");
        boutonConfirmerTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmerTable();
            }
        });

        panneauHaut.add(labelTitre);
        panneauHaut.add(separateur);
        panneauHaut.add(labelTable);
        panneauHaut.add(champNumeroTable);
        panneauHaut.add(boutonConfirmerTable);

        // ---- PANNEAU CENTRAL : 3 colonnes (menu | commande en cours | commandes validées) ----
        JPanel panneauCentre = new JPanel(new GridLayout(1, 3, 10, 0));

        // --- Colonne 1 : liste des plats du menu (JList + JScrollPane) ---
        JPanel panneauMenu = new JPanel(new BorderLayout());
        panneauMenu.setBorder(BorderFactory.createTitledBorder("Menu du restaurant"));

        // On crée le modèle de données pour la JList du menu
        DefaultListModel<String> modeleMenu = new DefaultListModel<>();
        ArrayList<Plat> tousLesPlats = menu.getPlats();

        // On remplit la liste avec chaque plat du menu
        for (int i = 0; i < tousLesPlats.size(); i++) {
            Plat p = tousLesPlats.get(i);
            modeleMenu.addElement(String.format("[%d] %s  -  %.2f EUR", (i + 1), p.getNom(), p.getPrix()));
        }

        // Création de la JList avec le modèle
        listeMenu = new JList<>(modeleMenu);
        listeMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeMenu.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // On enveloppe la JList dans un JScrollPane pour le défilement
        JScrollPane scrollMenu = new JScrollPane(listeMenu);
        panneauMenu.add(scrollMenu, BorderLayout.CENTER);

        // --- Colonne 2 : commande en cours de saisie ---
        JPanel panneauCommande = new JPanel(new BorderLayout(5, 5));
        panneauCommande.setBorder(BorderFactory.createTitledBorder("Commande en cours"));

        // Zone de texte non-éditable pour afficher la commande (JTextArea)
        zoneCommande = new JTextArea();
        zoneCommande.setEditable(false);
        zoneCommande.setFont(new Font("Monospaced", Font.PLAIN, 12));
        zoneCommande.setText("-- Aucun plat commandé --");

        // On enveloppe la JTextArea dans un JScrollPane
        JScrollPane scrollCommande = new JScrollPane(zoneCommande);

        // Étiquette affichant le total (JLabel)
        labelTotal = new JLabel("Total : 0,00 EUR");
        labelTotal.setFont(new Font("Arial", Font.BOLD, 14));
        labelTotal.setHorizontalAlignment(SwingConstants.RIGHT);

        // Panneau des boutons de la commande en cours
        JPanel panneauBoutonsCommande = new JPanel(new GridLayout(3, 1, 0, 5));

        // Bouton "Ajouter" : ajoute le plat sélectionné à la commande
        boutonAjouter = new JButton("Ajouter le plat sélectionné");
        boutonAjouter.setEnabled(false); // Désactivé jusqu'à confirmation de la table
        boutonAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ajouterPlat();
            }
        });

        // Bouton "Retirer" : retire le dernier plat ajouté
        boutonRetirer = new JButton("Retirer le dernier plat");
        boutonRetirer.setEnabled(false);
        boutonRetirer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retirerDernierPlat();
            }
        });

        // Bouton "Valider" : valide la commande et l'ajoute aux commandes en cours
        boutonValider = new JButton("Valider la commande");
        boutonValider.setEnabled(false);
        boutonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validerCommande();
            }
        });

        panneauBoutonsCommande.add(boutonAjouter);
        panneauBoutonsCommande.add(boutonRetirer);
        panneauBoutonsCommande.add(boutonValider);

        // Panneau bas de la colonne 2 : total + boutons
        JPanel basCommande = new JPanel(new BorderLayout(0, 5));
        basCommande.add(labelTotal, BorderLayout.NORTH);
        basCommande.add(panneauBoutonsCommande, BorderLayout.CENTER);

        panneauCommande.add(scrollCommande, BorderLayout.CENTER);
        panneauCommande.add(basCommande, BorderLayout.SOUTH);

        // --- Colonne 3 : commandes validées en cours ---
        JPanel panneauCommandesEnCours = new JPanel(new BorderLayout(5, 5));
        panneauCommandesEnCours.setBorder(BorderFactory.createTitledBorder("Commandes en cours"));

        // Modèle de données pour la liste des commandes validées
        modeleCommandes = new DefaultListModel<>();

        // JList des commandes en cours
        listeCommandes = new JList<>(modeleCommandes);
        listeCommandes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listeCommandes.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // On enveloppe dans un JScrollPane
        JScrollPane scrollCommandes = new JScrollPane(listeCommandes);

        // Panneau des boutons pour les commandes en cours
        JPanel panneauBoutonsListe = new JPanel(new GridLayout(2, 1, 0, 5));

        // Bouton "Afficher" : affiche le détail de la commande sélectionnée
        boutonAfficherCommande = new JButton("Afficher la commande");
        boutonAfficherCommande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                afficherCommandeSelectionnee();
            }
        });

        // Bouton "Supprimer" : supprime la commande sélectionnée
        boutonSupprimerCommande = new JButton("Supprimer la commande");
        boutonSupprimerCommande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                supprimerCommandeSelectionnee();
            }
        });

        panneauBoutonsListe.add(boutonAfficherCommande);
        panneauBoutonsListe.add(boutonSupprimerCommande);

        panneauCommandesEnCours.add(scrollCommandes, BorderLayout.CENTER);
        panneauCommandesEnCours.add(panneauBoutonsListe, BorderLayout.SOUTH);

        // On assemble les trois colonnes dans le panneau central
        panneauCentre.add(panneauMenu);
        panneauCentre.add(panneauCommande);
        panneauCentre.add(panneauCommandesEnCours);

        // ---- Assemblage final du panneau principal ----
        panneauPrincipal.add(panneauHaut, BorderLayout.NORTH);
        panneauPrincipal.add(panneauCentre, BorderLayout.CENTER);

        // On ajoute le panneau principal à la fenêtre
        add(panneauPrincipal);
    }

    // Méthode : confirme le numéro de table et crée la commande en cours
    private void confirmerTable() {

        String texte = champNumeroTable.getText().trim();

        // On vérifie que le champ n'est pas vide
        if (texte.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Veuillez entrer un numéro de table.",
                "Erreur",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // On tente de convertir la saisie en entier
        try {
            int numTable = Integer.parseInt(texte);

            // On crée une nouvelle commande pour cette table
            commande = new Commande(numTable);

            // On met à jour le titre de la fenêtre
            setTitle("Restaurant Java Bistro  -  Table N°" + numTable);

            // On active les boutons d'action de la commande en cours
            boutonAjouter.setEnabled(true);
            boutonRetirer.setEnabled(true);
            boutonValider.setEnabled(true);

            // On bloque la modification du numéro de table
            champNumeroTable.setEditable(false);

            // On réinitialise l'affichage de la commande en cours
            zoneCommande.setText("-- Aucun plat commandé --");
            labelTotal.setText("Total : 0,00 EUR");

            // On affiche une boîte de dialogue de confirmation (JOptionPane)
            JOptionPane.showMessageDialog(
                this,
                "Table N°" + numTable + " confirmée !\nVous pouvez maintenant passer votre commande.",
                "Bienvenue !",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (NumberFormatException ex) {
            // Si la saisie n'est pas un entier valide
            JOptionPane.showMessageDialog(
                this,
                "Le numéro de table doit être un nombre entier.",
                "Erreur de saisie",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Méthode : ajoute le plat sélectionné dans la JList à la commande en cours
    private void ajouterPlat() {

        // On récupère l'index sélectionné dans la JList (commence à 0)
        int index = listeMenu.getSelectedIndex();

        // Si aucun plat n'est sélectionné
        if (index == -1) {
            JOptionPane.showMessageDialog(
                this,
                "Veuillez sélectionner un plat dans la liste.",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // On récupère le plat correspondant dans le menu (index + 1 car getPlatParNumero commence à 1)
        Plat platChoisi = menu.getPlatParNumero(index + 1);

        // On ajoute le plat à la commande en cours
        commande.ajouterPlat(platChoisi);

        // On met à jour l'affichage de la commande en cours
        mettreAJourAffichageCommande();
    }

    // Méthode : retire le dernier plat ajouté à la commande en cours
    private void retirerDernierPlat() {

        // On vérifie que la commande n'est pas vide
        if (commande.getNombrePlats() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "La commande est déjà vide.",
                "Commande vide",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // On retire le dernier plat
        commande.supprimerDernierPlat();

        // On met à jour l'affichage
        mettreAJourAffichageCommande();
    }

    // Méthode : met à jour la JTextArea et le JLabel du total de la commande en cours
    private void mettreAJourAffichageCommande() {

        // Si la commande est vide, on réinitialise l'affichage
        if (commande.getNombrePlats() == 0) {
            zoneCommande.setText("-- Aucun plat commandé --");
            labelTotal.setText("Total : 0,00 EUR");
            return;
        }

        // On reconstruit le texte de la commande avec une boucle for
        StringBuilder contenu = new StringBuilder();
        ArrayList<Plat> platsCommandes = commande.getPlatsCommandes();

        for (int i = 0; i < platsCommandes.size(); i++) {
            Plat p = platsCommandes.get(i);
            contenu.append(String.format("%d. %s  -  %.2f EUR%n", (i + 1), p.getNom(), p.getPrix()));
        }

        // On affiche le contenu dans la JTextArea
        zoneCommande.setText(contenu.toString());

        // On met à jour le JLabel du total
        labelTotal.setText(String.format("Total : %.2f EUR", commande.calculerTotal()));
    }

    // Méthode : valide la commande en cours et l'ajoute à la liste des commandes en cours
    private void validerCommande() {

        // On vérifie que la commande n'est pas vide
        if (commande.getNombrePlats() == 0) {
            JOptionPane.showMessageDialog(
                this,
                "Votre commande est vide.\nAjoutez des plats avant de valider.",
                "Commande vide",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // On ajoute la commande validée au gestionnaire des commandes en cours
        gestionCommandes.ajouterCommande(commande);

        // On rafraîchit la liste graphique des commandes en cours
        rafraichirListeCommandes();

        // On affiche une confirmation
        JOptionPane.showMessageDialog(
            this,
            "Commande de la table N°" + commande.getNumeroTable() + " envoyée en cuisine !\n" +
            String.format("Total : %.2f EUR", commande.calculerTotal()) + "\n\n" +
            "Elle apparaît maintenant dans les commandes en cours.",
            "Commande validée !",
            JOptionPane.INFORMATION_MESSAGE
        );

        // On prépare la saisie d'une nouvelle commande (la liste en cours est conservée)
        preparerNouvelleCommande();
    }

    // Méthode : reconstruit la JList des commandes en cours à partir du gestionnaire
    private void rafraichirListeCommandes() {

        // On vide d'abord le modèle
        modeleCommandes.clear();

        // On parcourt toutes les commandes en cours avec une boucle for
        ArrayList<Commande> toutesLesCommandes = gestionCommandes.getCommandes();
        for (int i = 0; i < toutesLesCommandes.size(); i++) {
            Commande c = toutesLesCommandes.get(i);
            // On affiche un résumé : table, nombre de plats et total
            modeleCommandes.addElement(String.format(
                "Table %d  -  %d plat(s)  -  %.2f EUR",
                c.getNumeroTable(), c.getNombrePlats(), c.calculerTotal()
            ));
        }
    }

    // Méthode : affiche le détail de la commande sélectionnée dans la liste
    private void afficherCommandeSelectionnee() {

        // On récupère l'index sélectionné dans la JList des commandes
        int index = listeCommandes.getSelectedIndex();

        // Si aucune commande n'est sélectionnée
        if (index == -1) {
            JOptionPane.showMessageDialog(
                this,
                "Veuillez sélectionner une commande dans la liste.",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // On récupère la commande correspondante
        Commande c = gestionCommandes.getCommande(index);

        // On construit le détail de la commande
        StringBuilder detail = new StringBuilder();
        detail.append("DÉTAIL DE LA COMMANDE\n");
        detail.append("Table N°").append(c.getNumeroTable()).append("\n");
        detail.append("================================\n");

        ArrayList<Plat> platsCommandes = c.getPlatsCommandes();
        for (int i = 0; i < platsCommandes.size(); i++) {
            Plat p = platsCommandes.get(i);
            detail.append(String.format("%d. %s  -  %.2f EUR%n", (i + 1), p.getNom(), p.getPrix()));
        }

        detail.append("--------------------------------\n");
        detail.append(String.format("TOTAL : %.2f EUR", c.calculerTotal()));

        // Affichage du détail dans une boîte de dialogue (JOptionPane)
        JOptionPane.showMessageDialog(
            this,
            detail.toString(),
            "Commande - Table N°" + c.getNumeroTable(),
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // Méthode : supprime la commande sélectionnée dans la liste
    private void supprimerCommandeSelectionnee() {

        // On récupère l'index sélectionné
        int index = listeCommandes.getSelectedIndex();

        // Si aucune commande n'est sélectionnée
        if (index == -1) {
            JOptionPane.showMessageDialog(
                this,
                "Veuillez sélectionner une commande à supprimer.",
                "Aucune sélection",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // On récupère la commande pour afficher son numéro de table
        Commande c = gestionCommandes.getCommande(index);

        // On demande confirmation avant de supprimer (JOptionPane question)
        int reponse = JOptionPane.showConfirmDialog(
            this,
            "Voulez-vous vraiment supprimer la commande de la table N°" + c.getNumeroTable() + " ?",
            "Confirmer la suppression",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        // Si l'utilisateur confirme
        if (reponse == JOptionPane.YES_OPTION) {
            // On supprime la commande du gestionnaire
            gestionCommandes.supprimerCommande(index);

            // On rafraîchit la liste graphique
            rafraichirListeCommandes();
        }
    }

    // Méthode : prépare la saisie d'une nouvelle commande (sans toucher aux commandes en cours)
    private void preparerNouvelleCommande() {

        // On réinitialise la commande en cours de saisie
        commande = null;

        // On réactive et vide le champ de saisie de la table
        champNumeroTable.setEditable(true);
        champNumeroTable.setText("");

        // On remet le titre initial
        setTitle("Restaurant Java Bistro");

        // On désactive les boutons de la commande en cours
        boutonAjouter.setEnabled(false);
        boutonRetirer.setEnabled(false);
        boutonValider.setEnabled(false);

        // On réinitialise la zone d'affichage de la commande en cours
        zoneCommande.setText("-- Aucun plat commandé --");
        labelTotal.setText("Total : 0,00 EUR");

        // On désélectionne la liste des plats
        listeMenu.clearSelection();
    }
}
