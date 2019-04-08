# TP sur les Tests Unitaires (JUnit)

Petit exercice destiné à créer des tests unitaires.

```
Tests unitaires introduction

Distance de Levenshtein et objectifs du TP

L’objectif de ce TP est de tester une classe qui fournit un service très utile connu sous le nom de « calcul de distance de
Levenshtein ».
C’est cette méthode qui permet par exemple à un moteur de recherche de vous proposer des résultats pertinents même si
vous faites des erreurs d’orthographe.

Cet algorithme calcule le nombre d’insertions ou suppressions de caractères qu’il faut effectuer pour passer d’un mot à
un autre.
Ce nombre est ce qu’on appelle la distance de Levenshtein.

Exemples de distance de Levenshtein:
1) Entre « chat » et « chats » la distance de Levenshtein vaut 1 car il faut :
- ajouter une seule lettre (la lettre s) pour passer du mot « chat » au mot « chats ».
- ou supprimer une seule lettre pour passer du mot « chats » à « chat ».

2) Entre « machins » et « machine » la distance de Levenshtein vaut 1 car il faut remplacer une seule lettre pour
passer d’un mot à l’autre.

3) Entre « aviron » et « avion » la distance de Levenshtein vaut 1 car il faut retirer la lettre r du premier mot (ou
ajouter selon le sens).

4) Entre « distance » et « instance » quelle est la distance ?

5) Entre « Chien » et « Chine » quelle est la distance ?

Création du projet
• Créez un projet Maven demo-tests-unitaires.
• Synchronisez votre projet avec un projet GitHub
• Passez à la page suivante pour débuter le TP
```

```
Classe à tester
• Voici la classe dev.utils.StringUtils:

** Classe qui fournit des services de traitements de chaines de caractères
* @author DIGINAMIC
*/
public final class StringUtils {
/** Retourne la distance de Levenshtein entre 2 chaines de caractères
* @param lhs chaine 1
* @param rhs chaine 2
* @return distance
*/
public static int levenshteinDistance(CharSequence lhs, CharSequence rhs) {
int len0 = lhs.length() + 1;
int len1 = rhs.length() + 1;
int[] cost = new int[len0];
int[] newcost = new int[len0];
for (int i = 0; i < len0; i++) {
cost[i] = i;
}
for (int j = 1; j < len1; j++) {
newcost[0] = j;
for (int i = 1; i < len0; i++) {
int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;
int costReplace = cost[i - 1] + match;
int costInsert = cost[i] + 1;
int costDelete = newcost[i - 1] + 1;
newcost[i] = Math.min(Math.min(costInsert, costDelete), costReplace);

}
int[] swap = cost;
cost = newcost;
newcost = swap;
}
return cost[len0 - 1];
}
}
```
```
Recopiez cette classe dans votre projet.

Réalisez une nouvelle classe qui permet de tester la classe ci-dessus en respectant les instructions
suivantes :

a) Votre classe de tests doit générer une exception dès qu’un test ne passe pas.

b) Ne mettez pas votre classe de tests dans src/main/java.

a. Pensez à une configuration MAVEN spécifique pour les classes de tests.

c) Couvrez un maximum d’exemples (i.e. cas de tests)

d) Intéressez-vous également à la robustesse de cette classe. Que se passe t’il si on passe à cette
classe des paramètres NULL ? Proposez un correctif pour rendre cette classe plus robuste.

```