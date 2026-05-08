# Restaurant Order Manager
**Application Java de gestion de commandes pour un restaurant**
**레스토랑 주문 관리 Java 애플리케이션**

---

## Fonctionnalités / 기능

- Afficher le menu du restaurant (plats et boissons) / 메뉴 표시 (음식 및 음료)
- Ajouter des plats à une commande / 주문에 음식 추가
- Retirer le dernier plat ajouté / 마지막으로 추가한 음식 제거
- Voir le récapitulatif de la commande avec le total / 총액과 함께 주문 요약 보기
- Valider la commande / 주문 확정

---

## Structure du projet / 프로젝트 구조

```
restaurant-order-manager/
├── README.md
└── src/
    ├── Main.java       → Menu interactif en console (Scanner) / 콘솔 대화형 메뉴
    ├── Plat.java       → Classe de base : un plat / 기본 클래스 : 음식
    ├── Boisson.java    → Hérite de Plat (héritage) / Plat 상속 (상속)
    ├── Menu.java       → Liste des plats (ArrayList) / 메뉴 목록 관리
    └── Commande.java   → Commande d'un client (ArrayList) / 고객 주문 관리
```

---

## Concepts Java utilisés / 사용된 Java 개념

| Concept | Où / 위치 |
|---|---|
| Classes et objets / 클래스와 객체 | `Plat`, `Menu`, `Commande` |
| Héritage `extends` / 상속 | `Boisson extends Plat` |
| Redéfinition `@Override` / 메서드 재정의 | `Boisson.afficher()` |
| `ArrayList` | `Menu`, `Commande` |
| `Scanner` (saisie utilisateur / 사용자 입력) | `Main.java` |
| Boucles `while` et `for` / 반복문 | `Main.java`, `Commande.java` |
| `switch / case` | `Main.java` |

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

## Exemple d'utilisation / 사용 예시

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
