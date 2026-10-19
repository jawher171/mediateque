package tp_poo_avancee;

import java.util.List;

/**
 * SOLID Principles Demonstrated:
 *
 * 1. SRP (Single Responsibility Principle):
 *    Cette interface a pour unique responsabilité de définir le contrat de
 *    formatage d'une liste de documents en chaîne de caractères.
 *
 * 2. OCP (Open/Closed Principle):
 *    Le système est ouvert à l'extension (on peut ajouter FormatJson, FormatHtml, FormatXml)
 *    sans jamais modifier cette interface ni les services qui l'utilisent.
 *
 * 3. ISP (Interface Segregation Principle):
 *    Interface ciblée et minimale (une seule méthode), évitant de forcer les implémentations
 *    à dépendre de méthodes inutiles.
 *
 * 4. DIP (Dependency Inversion Principle):
 *    Sert d'abstraction entre les modules de haut niveau (RapportService)
 *    et les détails d'implémentation (FormatCsv, etc.).
 *
 * Pattern associé: Strategy (définit la stratégie de mise en forme).
 */
public interface FormatRapport {
    String formater(List<Document> docs);
}
