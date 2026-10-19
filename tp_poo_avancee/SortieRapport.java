package tp_poo_avancee;

import java.io.IOException;

/**
 * SOLID Principles Demonstrated:
 *
 * 1. SRP (Single Responsibility Principle):
 *    Responsable uniquement de définir le contrat d'écriture/persistance
 *    du rapport généré (vers fichier, console, réseau, base de données...).
 *
 * 2. DIP (Dependency Inversion Principle):
 *    Permet à RapportService de ne pas être couplé à une technologie d'E/S
 *    particulière (comme FileWriter ou System.out). Le service dépend de cette abstraction.
 *
 * 3. ISP (Interface Segregation Principle):
 *    Interface spécialisée et concise, contenant seulement la méthode ecrire().
 *
 * Pattern associé: Strategy / Bridge (découple l'abstraction de son implémentation d'E/S).
 */
public interface SortieRapport {
    void ecrire(String contenu) throws IOException;
}
