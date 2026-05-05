# Restaurant Order Manager

Application Java de gestion de commandes pour un restaurant, développée dans le cadre du cours de programmation Java.

## Fonctionnalités

- Afficher le menu du restaurant (plats et boissons)
- Ajouter des plats à une commande
- Retirer le dernier plat ajouté
- Voir le récapitulatif de la commande avec le total
- Valider la commande

## Structure du projet

```
restaurant-order-manager/
├── README.md
└── src/
    ├── Main.java       → Point d'entrée, menu interactif (Scanner)
    ├── Plat.java       → Classe de base représentant un plat
    ├── Boisson.java    → Hérite de Plat (héritage)
    ├── Menu.java       → Gère la liste des plats (ArrayList)
    └── Commande.java   → Gère la commande d'un client (ArrayList)
```

## Concepts Java utilisés

| Concept | Où |
|---|---|
| Classes et objets | `Plat`, `Menu`, `Commande` |
| Héritage (`extends`) | `Boisson extends Plat` |
| Redéfinition de méthode (`@Override`) | `Boisson.afficher()` |
| `ArrayList` | `Menu`, `Commande` |
| `Scanner` | `Main.java` |
| Boucles `while` et `for` | `Main.java`, `Commande.java` |
| `switch / case` | `Main.java` |

## Comment exécuter

1. Compiler tous les fichiers :
   ```bash
   cd src
   javac *.java
   ```

2. Lancer le programme :
   ```bash
   java Main
   ```

## Exemple d'utilisation

```
==========================================
  BIENVENUE AU RESTAURANT JAVA BISTRO
==========================================

Entrez le numéro de votre table : 3

---------- QUE VOULEZ-VOUS FAIRE ? ----------
  [1] Voir le menu du restaurant
  [2] Ajouter un plat à la commande
  [3] Retirer le dernier plat ajouté
  [4] Voir ma commande
  [5] Valider et quitter
Votre choix :
```
