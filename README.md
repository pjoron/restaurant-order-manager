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
- Gérer plusieurs commandes en même temps (plusieurs tables) / 여러 주문 동시 관리 (여러 테이블)
- Afficher la liste des commandes en cours / 진행 중인 주문 목록 표시
- Afficher le détail d'une commande en cours / 진행 중인 주문의 상세 내용 표시
- Supprimer une commande en cours (avec confirmation) / 진행 중인 주문 삭제 (확인 포함)
- Barre de menu (JMenuBar) avec "Fichier", "Aide" et "Langue" / "파일", "도움말", "언어" 메뉴 바 (JMenuBar)
- Interface bilingue : bascule français / coréen en un clic / 이중 언어 인터페이스 : 클릭 한 번으로 프랑스어 / 한국어 전환
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
    ├── Commande.java           → Commande d'un client (ArrayList) / 고객 주문 관리
    └── GestionCommandes.java   → Liste des commandes en cours (ArrayList) / 진행 중인 주문 목록 관리
```

---

## Concepts Java utilisés / 사용된 Java 개념

| Concept | Où / 위치 |
|---|---|
| Classes et objets / 클래스와 객체 | `Plat`, `Menu`, `Commande`, `GestionCommandes`, `FenetreRestaurant` |
| Héritage `extends` / 상속 | `Boisson extends Plat`, `FenetreRestaurant extends JFrame` |
| Redéfinition `@Override` / 메서드 재정의 | `Boisson.afficher()` |
| `ArrayList` | `Menu`, `Commande`, `GestionCommandes` |
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
+----------------------------------------------------------------------+
|  Fichier   Aide                                          [JMenuBar]   |
+----------------------------------------------------------------------+
|  Restaurant Java Bistro  |  Table: [__]  [Confirmer la table]        |
+----------------------------------------------------------------------+
| Menu du restaurant   | Commande en cours    | Commandes en cours     |
| [1] Soupe à l'oignon | 1. Steak - 15.00 EUR | Table 3 - 2 plats ...  |
| [2] Salade César     | 2. Crème - 5.50 EUR  | Table 5 - 1 plat ...   |
| [3] Steak frites     |                      | Table 7 - 4 plats ...  |
| ...                  | Total : 20.50 EUR    |                        |
|                      | [Ajouter le plat]    | [Afficher la commande] |
|                      | [Retirer le dernier] | [Supprimer la cmd]     |
|                      | [Valider]            |                        |
+----------------------------------------------------------------------+
```
