# Restaurant Order Manager
**Application Java de gestion de commandes pour un restaurant**
**레스토랑 주문 관리 Java 애플리케이션**

---

## Fonctionnalités / 기능

- Interface graphique complète avec Java Swing (JFrame, JPanel, JButton...) / Java Swing 그래픽 인터페이스 (JFrame, JPanel, JButton...)
- Afficher le menu du restaurant dans une JList avec défilement / JList에 스크롤과 함께 레스토랑 메뉴 표시
- Ajouter des plats à la commande via sélection graphique / 그래픽 선택으로 주문에 요리 추가
- Retirer le dernier plat ajouté / 마지막으로 추가한 요리 제거
- Voir le récapitulatif de la commande dans une JTextArea / JTextArea에서 주문 요약 보기
- Valider la commande avec une boîte de dialogue JOptionPane / JOptionPane 대화 상자로 주문 확정
- Barre de menu (JMenuBar) avec "Fichier" et "Aide" / "파일" 및 "도움말"이 있는 메뉴 바 (JMenuBar)
- Démarrer une nouvelle commande ou quitter depuis le menu / 메뉴에서 새 주문 시작 또는 종료

---

## Structure du projet / 프로젝트 구조

```
restaurant-order-manager/
├── README.md
└── src/
    ├── Main.java               → Lance l'interface graphique Swing / Swing GUI 실행
    ├── FenetreRestaurant.java  → Fenêtre principale (extends JFrame) / 메인 창 (JFrame 상속)
    ├── Plat.java               → Classe de base : un plat / 기본 클래스 : 요리
    ├── Boisson.java            → Hérite de Plat (héritage) / Plat 상속 (상속)
    ├── Menu.java               → Liste des plats (ArrayList) / 메뉴 목록 관리
    └── Commande.java           → Commande d'un client (ArrayList) / 고객 주문 관리
```

---

## Concepts Java utilisés / 사용된 Java 개념

| Concept | Où / 위치 |
|---|---|
| Classes et objets / 클래스와 객체 | `Plat`, `Menu`, `Commande`, `FenetreRestaurant` |
| Héritage `extends` / 상속 | `Boisson extends Plat`, `FenetreRestaurant extends JFrame` |
| Redéfinition `@Override` / 메서드 재정의 | `Boisson.afficher()` |
| `ArrayList` | `Menu`, `Commande` |
| `JFrame`, `JPanel`, `JButton` / GUI Swing | `FenetreRestaurant` |
| `JList`, `JScrollPane`, `JTextArea` / GUI Swing | `FenetreRestaurant` |
| `JMenuBar`, `JMenu`, `JMenuItem` / GUI Swing | `FenetreRestaurant` |
| `ActionListener` (gestion d'événements / 이벤트 처리) | `FenetreRestaurant` |
| `JOptionPane` (boîtes de dialogue / 대화 상자) | `FenetreRestaurant` |
| Boucles `for` / 반복문 | `FenetreRestaurant`, `Commande` |
| `try / catch` / 예외 처리 | `FenetreRestaurant` |

---

## Comment exécuter / 실행 방법

**1. Compiler / 컴파일 :**
```bash
cd src
javac *.java
```

**2. Lancer / 실행 :**
```bash
java Main
```

---

## Aperçu de l'interface / 인터페이스 미리보기

```
+------------------------------------------------------+
|  Fichier   Aide                         [JMenuBar]   |
+------------------------------------------------------+
|  Restaurant Java Bistro  | Table: [__] [Confirmer]   |
+------------------------------------------------------+
| Menu du restaurant  |  Votre commande                |
| [1] Soupe à l'oignon|  1. Steak frites - 15.00 EUR  |
| [2] Salade César    |  2. Crème brûlée - 5.50 EUR   |
| [3] Steak frites    |                                |
| ...                 |  Total : 20.50 EUR             |
+------------------------------------------------------+
| [Ajouter]  [Retirer le dernier plat]  [Valider]      |
+------------------------------------------------------+
```
