package tp_poo_avancee;

import java.util.Optional;

/*
 * ETAPE 3 - Reponses ecrites sur BibliothecaireAbusif (extends Catalogue<Document>)
 *
 * Q1. Un bibliothecaire est-il un catalogue ?
 *     Non. Un bibliothecaire est une personne qui UTILISE un catalogue. La relation
 *     "est un" est fausse : l'heritage n'a ete choisi que pour recuperer du code "gratuit".
 *
 * Q2. Que devient Bibliothecaire si Catalogue change ?
 *     Il change avec lui, sans qu'on y touche : renommer une methode, modifier une
 *     signature ou un comportement dans Catalogue se repercute sur le bibliothecaire.
 *     C'est le probleme de la classe de base fragile.
 *
 * Q3. Que signifie bibliothecaire.ajouter(livre) pour un client du code ?
 *     Rien de sense : le bibliothecaire "s'ajouterait" un livre a lui-meme. L'API publique
 *     du catalogue (ajouter, rechercherParTitre, afficherTout...) lui est imposee.
 *
 * Problemes de la conception avec heritage :
 *  1. Relation "est un" fausse : l'heritage sert a reutiliser du code, pas a specialiser.
 *  2. API polluee : un client voit ajouter / rechercherParTitre / afficherTout sur un
 *     bibliothecaire, l'encapsulation est affaiblie.
 *  3. Couplage maximal : toute evolution de Catalogue peut casser Bibliothecaire en silence.
 *  4. Substituabilite absurde : on pourrait passer un bibliothecaire partout ou un
 *     Catalogue est attendu (Catalogue<Document> c = bibliothecaire;).
 *  5. Heritage unique consomme : Bibliothecaire ne pourrait plus heriter de Personne
 *     ou Employe.
 *  6. Relation figee a la compilation : impossible de donner un autre catalogue au
 *     bibliothecaire (catalogue de test, section jeunesse...).
 *
 * Solution ci-dessous : COMPOSITION (le catalogue est un attribut recu par le
 * constructeur) + DELEGATION (chercher() confie le travail au catalogue).
 */
public class Bibliothecaire {
    private final String nom;
    private final Catalogue<Document> catalogue;   // COMPOSITION : possede un catalogue

    public Bibliothecaire(String nom, Catalogue<Document> catalogue) {
        this.nom = nom;
        this.catalogue = catalogue;
    }

    public void accueillir() {
        System.out.println("Bonjour, je suis " + nom);
    }

    // DELEGATION : on n'expose que ce qui a un sens pour un bibliothecaire
    public Optional<Document> chercher(String titre) {
        return catalogue.rechercherParTitre(titre);
    }
}
